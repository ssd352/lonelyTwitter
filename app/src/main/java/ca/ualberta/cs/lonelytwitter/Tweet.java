/*  Tweet
 *
 *  Version 1.0
 *
 *  Feb 01, 2018
 *
 *  Copyright © 2018 Team X, CMPUT301, University of Alberta – All Rights Reserved.
 *  You may use, distribute or modify this code under terms and conditions of Code of Student Behavior at
 *  University of Alberta.
 *  You can find a copy of the license in this project. Otherwise, please contact contact@abc.ca
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Represents a tweet
 *
 * @author dezfuli
 *
 * @version 1.0
 *
 * @see ImportantTweet
 * @see NormalTweet
 */
public abstract class Tweet implements Tweetable {
    private String message;
    private Date date;

    /**
     * Constructs a tweet instance using the given message
     *
     * @param message the message of the tweet
     */
    Tweet(String message){

        this.message = message;
        date = new Date();
//        message = message;
    }

    Tweet(String message, Date date){
        this.message = message;
        this.date = date;
    }

    public String getMessage(){
        return message;
    }

    /**
     * Sets the message of the tweet
     *
     * @param message the new message of the tweet
     * @throws TweetTooLongException is thrown when the message is over 140 characters
     *
     * @see ImportantTweet
     * @see NormalTweet
     */
    public void setMessage(String message) throws TweetTooLongException{
        if (message.length() < 140){
            this.message = message;
        }
        else{
            throw new TweetTooLongException();
        }
    }

    public Date getDate(){
        return date;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public abstract Boolean isImportant();

    public String toString() {
        return date.toString() + " | " + message;
    }

}
