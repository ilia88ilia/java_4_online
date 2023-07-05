package ua.com.illia.api.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ua.com.illia.api.AccountApiService;
import ua.com.illia.model.AccountDetailsModel;
import ua.com.illia.model.AccountModel;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AccountApiServiceImpl implements AccountApiService {
    @Value("${finance.backend.api.url}")
    private String apiUrl;

    @Override
    public Optional<AccountDetailsModel> findById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<AccountDetailsModel> responseEntity = restTemplate.exchange(
                    apiUrl + "/accounts/" + id,
                    HttpMethod.GET,
                    null,
                    AccountDetailsModel.class
            );

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                AccountDetailsModel accountDetailsModel = responseEntity.getBody();
                if (accountDetailsModel != null) {
                    return Optional.of(accountDetailsModel);
                }
            }
            return Optional.empty();
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Collection<AccountModel> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<AccountModel[]> responseEntity = restTemplate.exchange(
                apiUrl + "/accounts",
                HttpMethod.GET,
                null,
                AccountModel[].class
        );

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            AccountModel[] accountModels = responseEntity.getBody();
            if (accountModels != null) {
                return List.of(accountModels);
            }
        }

        return Collections.emptyList();
    }

}