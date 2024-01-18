package com.lingolift.lingoliftbackend.dto;

public class ChatGPTRequest {

    private String model;
    private String prompt;

    private int temperature = 1;
    private int max_tokens = 256;
    private int top_p = 1;
    private int frequency_penalty = 0;
    private int presence_penalty = 0;

    public ChatGPTRequest() {

    }

    public ChatGPTRequest(String model, String prompt) {
        this.model = model;
        this.prompt = prompt;
    }
}
