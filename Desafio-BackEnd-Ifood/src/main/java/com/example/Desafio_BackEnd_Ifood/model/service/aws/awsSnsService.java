package com.example.Desafio_BackEnd_Ifood.model.service.aws;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.Topic;
import com.example.Desafio_BackEnd_Ifood.controller.dto.MessageDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class awsSnsService {
	
	 	private final AmazonSNS snsClient;
	    @Qualifier("catalogEventsTopic")
	    private final Topic catalogTopic;


	    public void publish(MessageDTO message) {
	        System.out.println(message.getOwnerId());
	        snsClient.publish(catalogTopic.getTopicArn(), message.getOwnerId());
	    }
	}
