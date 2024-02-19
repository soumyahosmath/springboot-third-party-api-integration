package com.example.resttemplate.springbootresttemplate.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.resttemplate.springbootresttemplate.dto.UserDetailsDTO;
import com.example.resttemplate.springbootresttemplate.model.UserDetails;
@Service
public class UserService {
	
	private final RestTemplate restTemplate;

    @Autowired
    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    public List<UserDetailsDTO> fetchDataFromUrl(String url) {
        ResponseEntity<UserDetails[]> response = restTemplate.getForEntity(url, UserDetails[].class);
        UserDetails[] users = response.getBody();
        
        List<UserDetailsDTO> userDetailsDTOList = new ArrayList<>();
        for (UserDetails user : users) {
            UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
            userDetailsDTO.setLatitude(user.getAddress().getGeo().getLat());
            userDetailsDTO.setLongitude(user.getAddress().getGeo().getLng());
            userDetailsDTO.setCompanyName(user.getCompany().getName());
            userDetailsDTOList.add(userDetailsDTO);
        }
        return userDetailsDTOList;
    }
}
