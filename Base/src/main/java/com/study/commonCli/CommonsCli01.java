package com.study.commonCli;

import org.apache.commons.cli.*;

public class CommonsCli01 {
    public static void main(String[] args) {
        // Options 准备阶段，准备好所有的选项
        Options options = new Options();
        Option opt = new Option("h", "help", false, "Print help");
        opt.setRequired(false);
        options.addOption(opt);

        opt = new Option("c", "configFile", true, "Name server config properties file");
        opt.setRequired(false);
        options.addOption(opt);

        opt = new Option("p", "printConfigItem", false, "Print all config item");
        opt.setRequired(false);
        options.addOption(opt);

        // 帮助打印
        HelpFormatter hf = new HelpFormatter();
        hf.setWidth(110);

        // 解析从命令行传过来的参数
        CommandLine commandLine = null;

        DefaultParser parser = new DefaultParser();
        try {
            // 得到 CommandLine 对象
            commandLine = parser.parse(options, args);

            // 根据不同的参数处理不同的业务逻辑
            // h 打印帮助信息
            if (commandLine.hasOption('h')) {
                // 打印使用帮助
                hf.printHelp("testApp", options, true);
            }

            // 打印opts的名称和值
            System.out.println("--------------------------------------");
            Option[] opts = commandLine.getOptions();
            if (opts != null) {
                for (Option opt1 : opts) {
                    String name = opt1.getLongOpt();
                    String value = commandLine.getOptionValue(name);
                    System.out.println(name + "=>" + value);
                }
            }
        }
        catch (ParseException e) {
            hf.printHelp("testApp", options, true);
        }
    }
}
