package com.example.bajajHDC.service;

import com.example.bajajHDC.model.DataRequest;
import com.example.bajajHDC.model.DataResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class bfhlservice {
    public DataResponse processData(DataRequest request) {
        List<String> numbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        List<String> highestAlphabet = new ArrayList<>();

        // Check if request data is not null
        if (request.getData() != null) {
            // Logic to differentiate numbers and alphabets
            for (String item : request.getData()) {
                if (item.matches("[0-9]+")) {
                    numbers.add(item);
                } else if (item.matches("[a-zA-Z]+")) {
                    alphabets.add(item);
                }
            }

            // Logic to find the highest alphabet
            if (!alphabets.isEmpty()) {
                highestAlphabet.add(alphabets.stream()
                        .max(String::compareToIgnoreCase)
                        .orElse(""));
            }
        }

        DataResponse response = new DataResponse();
        response.setIs_success(true); // Set to true only if data is processed correctly
        response.setUser_id("john_doe_17091999"); // Replace with dynamic generation
        response.setEmail("john@xyz.com"); // Replace with actual data
        response.setRoll_number("ABCD123"); // Replace with actual data
        response.setNumbers(numbers);
        response.setAlphabets(alphabets);
        response.setHighest_alphabet(highestAlphabet);

        return response;
    }
}
