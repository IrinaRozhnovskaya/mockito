package com.spring.example.mockito;

class SomeBusinessImpl {

    private DataService dataService;

    SomeBusinessImpl(DataService dataService) {
        this.dataService = dataService;
    }

    int findTheGreatestFromAllData() {
        int[] allData = dataService.retrieveAllData();
        int greatest = Integer.MIN_VALUE;

        for (int value : allData) {
            if (value > greatest) {
                greatest = value;
            }
        }
        return greatest;
    }
}
