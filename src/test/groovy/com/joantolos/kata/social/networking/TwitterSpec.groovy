package com.joantolos.kata.social.networking

import com.joantolos.kata.social.networking.ui.UserInterface
import spock.lang.Specification

class TwitterSpec extends Specification {

    Twitter twitter

    def setup() {
        twitter = new Twitter(new UserInterface())
        twitter.processCommand("Joan -> Hello there")
        Thread.sleep(500)
        twitter.processCommand("Andy -> This is Andy")
        Thread.sleep(500)
        twitter.processCommand("Joan follows Andy")
        twitter.processCommand("Joan -> I am happy")
        Thread.sleep(500)
    }

    def "Twitter should post"(){
        expect:
        twitter.processCommand("Joan -> Hello there") == "Message posted!\n"
        twitter.processCommand("Joan -< Hello there") == ""
    }

    def "Twitter should read"(){
        expect:
        twitter.processCommand("Joan").split("\n")[0].contains("I am happy")
        twitter.processCommand("Joan").split("\n")[1].contains("Hello there")
        twitter.processCommand("Andy").split("\n")[0].contains("This is Andy")
    }

    def "Twitter should follow"(){
        expect:
        twitter.processCommand("Joan follows Andy") == "Joan now follows Andy\n"
    }

    def "Twitter should show wall"(){
        expect:
        twitter.processCommand("Joan wall").split("\n")[0].contains("Joan -> I am happy")
        twitter.processCommand("Joan wall").split("\n")[1].contains("Andy -> This is Andy")
        twitter.processCommand("Joan wall").split("\n")[2].contains("Joan -> Hello there")
    }

    def "Twitter should print result"(){
        expect:
        twitter.printCommandResult("Joan -> Hello there")
        !twitter.printCommandResult("")
    }
}
