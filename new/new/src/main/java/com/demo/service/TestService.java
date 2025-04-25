package com.demo.service;

import com.demo.model.TestData;
import com.demo.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    // Insert or Save Data
    public Mono<String> insertTestData(TestData testData) {
        return Mono.fromCallable(() -> {
            testRepository.save(testData);
            return "Inserted: Name: " + testData.getName() + ", Age: " + testData.getAge() + ", Email: " + testData.getEmail();
        });
    }

    // Select Data by ID
    public Mono<TestData> selectTestData(Long id) {
        return Mono.fromCallable(() -> {
            Optional<TestData> testData = testRepository.findById(id);
            return testData.orElseThrow(() -> new RuntimeException("Data not found for ID: " + id));
        });
    }

    // Update Data
    public Mono<String> updateTestData(Long id, TestData updatedData) {
        return Mono.fromCallable(() -> {
            TestData existingData = testRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Data not found for ID: " + id));
            existingData.setName(updatedData.getName());
            existingData.setAge(updatedData.getAge());
            existingData.setEmail(updatedData.getEmail());
            testRepository.save(existingData);
            return "Updated: ID: " + id + ", Name: " + updatedData.getName() + ", Age: " + updatedData.getAge() + ", Email: " + updatedData.getEmail();
        });
    }

    // Delete Data by ID
    public Mono<String> deleteTestData(Long id) {
        return Mono.fromCallable(() -> {
            if (testRepository.existsById(id)) {
                testRepository.deleteById(id);
                return "Deleted data with ID: " + id;
            } else {
                throw new RuntimeException("Data not found for ID: " + id);
            }
        });
    }

    public Mono<String> processTestData(TestData testData) {
        // Simulate processing logic
        return Mono.just("Name: " + testData.getName() + ", Age: " + testData.getAge() + ", Email: " + testData.getEmail());
    }
}