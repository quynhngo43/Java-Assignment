package com.kms.objects;

import java.util.ArrayList;
import java.util.List;

public class Questions {
    private String id;
    private String type;
    private String name;
    private List<String> question = new ArrayList<>();

    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuestion(List<String> question) {
        for (int i = 0; i < question.size(); i++) {
            this.question.add(question.get(i));
        }
    }

    public String getId() {
        return this.id;
    }

    public String getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getQuestion() {
        return this.question;
    }
}