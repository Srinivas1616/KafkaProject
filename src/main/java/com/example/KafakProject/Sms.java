package com.example.KafakProject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sms {
	
	private String from;
	private String to;
	private String body;

}
