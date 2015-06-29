package com.lanino.core;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

public class History {

	private long id;

    @Length(max = 3)
    private String content;

    public History() {
        // Jackson deserialization
    }

    public History(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
	
}
