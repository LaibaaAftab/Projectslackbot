package com.example.projectslackbot;

import com.github.seratch.jslack.app_backend.dialogs.payload.PayloadTypeDetector;
import com.slack.api.Slack;
import com.slack.api.methods.SlackApiException;
import com.slack.api.webhook.Payload;
import com.slack.api.webhook.WebhookResponse;

import java.io.IOException;

public class slackAPI{
    private static String laiba="https://hooks.slack.com/services/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";
    private static String bsef19a524="https://hooks.slack.com/services/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";
    public static int sendmessage(String msg,String handle)
    {
        String[] name={"Laiba Aftab","bsef19a524"};
        String[] credentials={laiba,bsef19a524};
        int h = -1;
        try {
            for(int i =0;i<name.length;i++)
            {
                if(name[i].equals(handle))
                {
                    h =  i;
                    break;
                }
            }
            if(h>=0) {
                StringBuilder message = new StringBuilder();
                message.append(msg);
                Payload p = Payload.builder().channel("reminder").text(message.toString()).build();
                WebhookResponse ebresp = Slack.getInstance().send(credentials[h], p);

            }
            return 1;
        }
        catch(Exception e)
        {
            System.out.println("slack exception");
            return -1;
        }
    }
}
