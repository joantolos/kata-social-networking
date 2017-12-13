package com.joantolos.kata.social.networking.command

import spock.lang.Specification

class CommandFactorySpec extends Specification {

    def "Should recognize post command"(){
        expect:
        command instanceof PostCommand

        where:
        command = CommandFactory.build("Joan -> Hello there")
    }

    def "Should recognize post command with special characters"(){
        expect:
        command instanceof PostCommand

        where:
        command = CommandFactory.build("Charlie -> I'm in New York today! Anyone wants to have a coffee?")
    }

    def "Should recognize read command"(){
        expect:
        command instanceof ReadCommand

        where:
        command = CommandFactory.build("Charlie")
    }

    def "Should recognize follow command"(){
        expect:
        command instanceof FollowCommand

        where:
        command = CommandFactory.build("Joan follows Charlie")
    }

    def "Should recognize wall command"(){
        expect:
        command instanceof WallCommand

        where:
        command = CommandFactory.build("Joan wall")
    }
}
