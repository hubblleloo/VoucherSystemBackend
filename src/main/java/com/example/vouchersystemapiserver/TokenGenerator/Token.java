package com.example.vouchersystemapiserver.TokenGenerator;

import java.util.Random;

public class Token {
    private static final Random RND=new Random(System.currentTimeMillis());

    public static String generate(CodeConfig config){
        StringBuilder sb=new StringBuilder();
        char[] chars=config.getCharset().toCharArray();
        char[] pattern=config.getPattern().toCharArray();

        if (config.getPrefix()!=null){
            sb.append(config.getPrefix());
        }

        for (int i=0; i<pattern.length;i++){
            if (pattern[i] == CodeConfig.PATTERN_PLACEHOLDER){
                sb.append(chars[RND.nextInt(chars.length)]);
            }else{
                sb.append(pattern[i]);
            }
        }

        if(config.getPostfix()!=null){
            sb.append(config.getPostfix());
        }
        return sb.toString();
    }
}
