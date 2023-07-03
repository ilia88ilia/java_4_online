package ua.com.illia.api.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ua.com.illia.api.UserApiService;
import ua.com.illia.model.AccountPostModel;
import ua.com.illia.model.UserDetailsModel;
import ua.com.illia.model.UserModel;
import ua.com.illia.model.UserAccountModel;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserApiServiceImpl implements UserApiService {
    @Value("${finance.backend.api.url}")
    private String apiUrl;

    @Override
    public Boolean create(UserModel user) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<Boolean> responseEntity = restTemplate.exchange(
                    apiUrl + "/users",
                    HttpMethod.POST,
                    ResponseEntity.ok(user),
                    Boolean.class
            );
            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                return responseEntity.getBody();
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean createAccount(AccountPostModel account, Long id) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<Boolean> responseEntity = restTemplate.exchange(
                    apiUrl + "/users/" + id,
                    HttpMethod.POST,
                    ResponseEntity.ok(account),
                    Boolean.class
            );
            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                return responseEntity.getBody();
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Optional<UserDetailsModel> findById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<UserDetailsModel> responseEntity = restTemplate.exchange(
                    apiUrl + "/users/" + id,
                    HttpMethod.GET,
                    null,
                    UserDetailsModel.class
            );

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                UserDetailsModel userModel = responseEntity.getBody();
                if (userModel != null) {
                    return Optional.of(userModel);
                }
            }
            return Optional.empty();
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Collection<UserAccountModel> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserAccountModel[]> responseEntity = restTemplate.exchange(
                apiUrl + "/users",
                HttpMethod.GET,
                null,
                UserAccountModel[].class
        );

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            UserAccountModel[] userModels = responseEntity.getBody();
            if (userModels != null) {
                return List.of(userModels);
            }
        }

        return Collections.emptyList();
    }
}
