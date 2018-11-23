package com.lynas

import com.pastdev.jsch.DefaultSessionFactory
import com.pastdev.jsch.command.CommandRunner

import java.util.HashMap

fun main(args: Array<String>) {
    val sessionFactory = DefaultSessionFactory("lynas", "192.168.106.128", 22)
    sessionFactory.setPassword("87")
    val config = mapOf("StrictHostKeyChecking" to "no")
    sessionFactory.setConfig(config)
    val runner = CommandRunner(sessionFactory)
    val command = "ls -al"
    val result = runner.execute(command)
    if (result.stderr.isEmpty()) {
        println(result.stdout)
    } else {
        println(result.stderr)
    }
    runner.close()

}