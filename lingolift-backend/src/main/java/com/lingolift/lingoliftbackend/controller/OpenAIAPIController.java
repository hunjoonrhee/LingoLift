package com.lingolift.lingoliftbackend.controller;


import com.lingolift.lingoliftbackend.dto.ChatGPTRequest;
import com.lingolift.lingoliftbackend.dto.ChatGPTResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/chat")
public class OpenAIAPIController {

    @Value("${openai.api.model}")
    private String model;

    @Value("${openai.api.url}")
    private String url;

    @Autowired
    private RestTemplate template;

    @GetMapping()
    public String chat(@RequestParam String prompt) {
        ChatGPTRequest chatGPTRequest = new ChatGPTRequest(model, prompt);

        ChatGPTResponse chatGPTResponse = template.postForObject(url, chatGPTRequest, ChatGPTResponse.class);

        assert chatGPTResponse != null;
        return chatGPTResponse.getChoices().get(0).getText();
    }
}
