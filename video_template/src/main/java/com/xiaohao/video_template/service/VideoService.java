package com.xiaohao.video_template.service;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.springframework.stereotype.Service;

@Service
public class VideoService {

    private static final IAcsClient CLIENT;

    static {
        IClientProfile profile = DefaultProfile.getProfile("cn-shanghai", "<your accessKey>", "<your accessSecret>");
        CLIENT = new DefaultAcsClient(profile);
    }




}
