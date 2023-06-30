package ua.com.illia.api.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ua.com.illia.api.TransactionApiService;
import ua.com.illia.model.TransactionDetailsModel;
import ua.com.illia.model.TransactionModel;
import ua.com.illia.model.TransactionPostModel;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionApiServiceImpl implements TransactionApiService {
    @Value("${finance.backend.api.url}")
    private String apiUrl;

    @Override
    public void exportByAccId(long id) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<Boolean> responseEntity = restTemplate.exchange(
                    apiUrl + "/transactions/export/" + id,
                    HttpMethod.POST,
                    null,
                    Boolean.class
            );
            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                responseEntity.getBody();
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void exportAll() {
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<Boolean> responseEntity = restTemplate.exchange(
                    apiUrl + "/transactions/export",
                    HttpMethod.POST,
                    null,
                    Boolean.class
            );
            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                responseEntity.getBody();
            }
        } catch (Exception e) {
        }
    }

    @Override
    public Boolean create(TransactionPostModel transaction) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<Boolean> responseEntity = restTemplate.exchange(
                    apiUrl + "/transactions",
                    HttpMethod.POST,
                    ResponseEntity.ok(transaction),
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
    public Optional<TransactionDetailsModel> findById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<TransactionDetailsModel> responseEntity = restTemplate.exchange(
                    apiUrl + "/transactions/" + id,
                    HttpMethod.GET,
                    null,
                    TransactionDetailsModel.class
            );

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                TransactionDetailsModel transactionDetailsModel = responseEntity.getBody();
                if (transactionDetailsModel != null) {
                    return Optional.of(transactionDetailsModel);
                }
            }
            return Optional.empty();
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Collection<TransactionModel> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<TransactionModel[]> responseEntity = restTemplate.exchange(
                apiUrl + "/transactions",
                HttpMethod.GET,
                null,
                TransactionModel[].class
        );

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            TransactionModel[] transactionModels = responseEntity.getBody();
            if (transactionModels != null) {
                return List.of(transactionModels);
            }
        }

        return Collections.emptyList();
    }
}
