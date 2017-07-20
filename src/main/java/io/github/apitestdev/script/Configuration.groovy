package io.github.apitestdev.script

/**
 * 全局配置信息
 */
abstract class Configuration extends Script {
    String protocol = 'http'
    String host
    int port = 80
    String dataSource
}
