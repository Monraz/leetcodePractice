package may;/*
Goal
----
You will be entering an HTTP maze. Your goal is to get out of it!

API
---
ENDPOINT = "https://surrounded-chapel-ak-great.trycloudflare.com"
The maze will be represented as an API with one GET endpoint.
To enter the maze, head over to https://surrounded-chapel-ak-great.trycloudflare.com
To go to a specific step in the maze, GET /<STEP_ID>
The final step of the maze will return a "CONGRATS" message.

Instructions
------------
Print the STEP_ID of the final step
*/

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.io.IOException;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonProperty;

class Solution {
    private static final String URL = "https://surrounded-chapel-ak-great.trycloudflare.com";
    public static class ResponseData {
        @JsonProperty("next_steps")
        public List<String> nextSteps;

        @Override
        public String toString() {
            return "Next Steps: " + nextSteps;
        }
    }

    public static class Requests {
        private final HttpClient client = HttpClient.newHttpClient();
        private final ObjectMapper mapper = new ObjectMapper();

        public List<String> jumpToNextStep(String step, Set<String> traversedSteps) {
            try {
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(URL + "/" + step))
                        .header("Content-Type", "application/json")
                        .GET()
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                List<String> nextSteps = (mapper.readValue(response.body(), ResponseData.class)).nextSteps;
                nextSteps.removeAll(traversedSteps);
                return nextSteps;
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
                return Collections.EMPTY_LIST;
            }
        }

        public List<String> getAndParseJson() {
            return jumpToNextStep("", Collections.EMPTY_SET);
        }
    }

    public static void main(String[] args) {
        Requests request = new Requests();

        Set<String> traversedSteps = new HashSet<>();
        Stack<String> notTraversedBifurcationsStack = new Stack<>();
        List<String> currentStepOptions = request.getAndParseJson();
        String currentStep = currentStepOptions.getFirst();
        notTraversedBifurcationsStack.addAll(currentStepOptions.subList(1, currentStepOptions.size()));
        while (!currentStep.equals("CONGRATS")) {
            System.out.println(currentStep);
            currentStepOptions = request.jumpToNextStep(currentStep, traversedSteps);
            if (currentStepOptions.isEmpty()) {
                while (currentStepOptions.isEmpty()) {
                    currentStep = notTraversedBifurcationsStack.pop();
                    currentStepOptions = request.jumpToNextStep(currentStep, traversedSteps);
                }
            }
            traversedSteps.add(currentStep);
            currentStep = currentStepOptions.getFirst();
            notTraversedBifurcationsStack.addAll(currentStepOptions.subList(1, currentStepOptions.size()));
        }
        System.out.println(currentStep);
    }
}