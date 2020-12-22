package com.mzll.test.aliyunn.bean;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.vod.model.v20170321.*;

import java.util.List;
public class InitVodClient {
    public static DefaultAcsClient initVodClient(String accessKeyId, String accessKeySecret, String securityToken) throws ClientException {
        String regionId = "cn-shanghai";  // 点播服务接入区域
        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret, securityToken);
        DefaultAcsClient client = new DefaultAcsClient(profile);
        return client;
    }

    public static DefaultAcsClient initVodClient(String accessKeyId, String accessKeySecret) throws ClientException {
        String regionId = "cn-shanghai";  // 点播服务接入区域
        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
        DefaultAcsClient client = new DefaultAcsClient(profile);
        return client;
    }

    /**
     * 获取视频上传地址和凭证
     *
     * @param client 发送请求客户端
     * @return CreateUploadVideoResponse 获取视频上传地址和凭证响应数据
     * @throws Exception
     */
    public static CreateUploadVideoResponse createUploadVideo(DefaultAcsClient client) throws Exception {
        CreateUploadVideoRequest request = new CreateUploadVideoRequest();
        request.setTitle("this is a sample");
        request.setFileName("filename.mp4");

        //UserData，用户自定义设置参数，用户需要单独回调URL及数据透传时设置(非必须)
        //JSONObject userData = new JSONObject();

        //UserData回调部分设置
        //JSONObject messageCallback = new JSONObject();
        //messageCallback.put("CallbackURL", "http://192.168.0.0/16");
        //messageCallback.put("CallbackType", "http");
        //userData.put("MessageCallback", messageCallback.toJSONString());

        //UserData透传数据部分设置
        //JSONObject extend = new JSONObject();
        //extend.put("MyId", "user-defined-id");
        //userData.put("Extend", extend.toJSONString());

        //request.setUserData(userData.toJSONString());

        return client.getAcsResponse(request);
    }

    // 请求示例
   /* public static void main(String[] argv) throws ClientException {
        String accessKeyId = "LTAI4Fnd2UQbmyQ2wcmBLRE6";
        String accessKeySecret = "Ew0Kf0Hgvkg6rPb5atSVSusgF4cBRP";
        DefaultAcsClient client = initVodClient(accessKeyId, accessKeySecret);
        CreateUploadVideoResponse response = new CreateUploadVideoResponse();
        GetPlayInfoResponse playInfoResponse;

        try {

            // 获取播放地址
            playInfoResponse = getPlayInfo(client);
            List<GetPlayInfoResponse.PlayInfo> playInfoList = playInfoResponse.getPlayInfoList();
            playInfoList.forEach(playInfo -> System.out.println("*************************************************"+playInfo.getPlayURL()));
            response = createUploadVideo(client);
            System.out.print("VideoId = " + response.getVideoId() + "\n");
            System.out.print("UploadAddress = " + response.getUploadAddress() + "\n");
            System.out.print("UploadAuth = " + response.getUploadAuth() + "\n");
        } catch (Exception e) {
            System.out.print("ErrorMessage = " + e.getLocalizedMessage());
        }
        System.out.print("RequestId = " + response.getRequestId() + "\n");
    }*/


    /**
     * 刷新视频上传凭证
     *
     * @param client 发送请求客户端
     * @return RefreshUploadVideoResponse 刷新视频上传凭证响应数据
     * @throws Exception
     */
    public static RefreshUploadVideoResponse refreshUploadVideo(DefaultAcsClient client) throws Exception {
        RefreshUploadVideoRequest request = new RefreshUploadVideoRequest();
        request.setVideoId("VideoId");
        return client.getAcsResponse(request);
    }

    // 请求示例
//    public static void main(String[] argv) {
//        DefaultAcsClient client = initVodClient("<Your AccessKeyId>", "<Your AccessKeySecret>");
//        RefreshUploadVideoResponse response = new RefreshUploadVideoResponse();
//        try {
//            response = refreshUploadVideo(client);
//            System.out.print("UploadAddress = " + response.getUploadAddress() + "\n");
//            System.out.print("UploadAuth = " + response.getUploadAuth() + "\n");
//        } catch (Exception e) {
//            System.out.print("ErrorMessage = " + e.getLocalizedMessage());
//        }
//        System.out.print("RequestId = " + response.getRequestId() + "\n");
//    }

    /**
     * 获取图片上传地址和凭证
     *
     * @param client 发送请求客户端
     * @return CreateUploadImageResponse 获取图片上传地址和凭证响应数据
     * @throws Exception
     */
   /* public static CreateUploadImageResponse createUploadImage(DefaultAcsClient client) throws Exception {
        CreateUploadImageRequest request = new CreateUploadImageRequest();
        request.setImageType("default");
        request.setImageExt("gif");
        request.setTitle("this is a sample");

        JSONObject userData = new JSONObject();

        JSONObject messageCallback = new JSONObject();
        messageCallback.put("CallbackURL", "http://192.168.0.0/16");
        messageCallback.put("CallbackType", "http");
        userData.put("MessageCallback", messageCallback.toJSONString());

        JSONObject extend = new JSONObject();
        extend.put("MyId", "user-defined-id");
        userData.put("Extend", extend.toJSONString());

        request.setUserData(userData.toJSONString());

        return client.getAcsResponse(request);
    }*/

    // 请求示例
    /*public static void main(String[] argv) {
        DefaultAcsClient client = initVodClient("<Your AccessKeyId>", "<Your AccessKeySecret>");
        CreateUploadImageResponse response = new CreateUploadImageResponse();
        try {
            response = createUploadImage(client);
            System.out.print("ImageId = " + response.getImageId() + "\n");
            System.out.print("ImageURL = " + response.getImageURL() + "\n");
            System.out.print("UploadAddress = " + response.getUploadAddress() + "\n");
            System.out.print("UploadAuth = " + response.getUploadAuth() + "\n");
        } catch (Exception e) {
            System.out.print("ErrorMessage = " + e.getLocalizedMessage());
        }
        System.out.print("RequestId = " + response.getRequestId() + "\n");
    }*/

    /*获取播放地址函数*/
    public static GetPlayInfoResponse getPlayInfo(DefaultAcsClient client) throws Exception {
        GetPlayInfoRequest request = new GetPlayInfoRequest();
//        request.setVideoId("0d237a6a1b2245f3b1674506538780a8");// 将故事。。。
        request.setVideoId("511ff2ec9e9746d69b510f85f5f691d6");// gaoxiao
        return client.getAcsResponse(request);
    }


}
