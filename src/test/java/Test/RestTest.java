///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Test;
//
//import org.apache.http.HttpResponse;
//import org.apache.http.NameValuePair;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.*;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.message.BasicNameValuePair;
//import org.junit.Before;
//import org.junit.Test;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.mockito.InjectMocks;
//
//import static org.junit.Assert.*;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//
///**
// *
// * @author saya
// */
//public class RestTest {
//    
//    @Before
//    public void setUp()throws IOException {
//        HttpPost post = new HttpPost("http://localhost:8080/Kwetter/resources/remove/aap");
//        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
//        nameValuePairs.add(new BasicNameValuePair("username", "aap"));
//        post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
//        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(post);
//    }
//
//    @Test
//    public void testAddAndGetUser() throws IOException {
//        // verify that the user does not exist yet
//        HttpUriRequest request = new HttpGet("http://localhost:8080/Kwetter/resources/user/aap");
//        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
//        assertEquals(204, httpResponse.getStatusLine().getStatusCode());
//
////        // add user with succes
////        HttpPost post = new HttpPost("http://localhost:8080/Kwetter/resources/user/create");
////        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
////        nameValuePairs.add(new BasicNameValuePair("username", "aap"));
////        //nameValuePairs.add(new BasicNameValuePair("password", "test"));
////        post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
////        httpResponse = HttpClientBuilder.create().build().execute(post);
////        assertEquals(200,httpResponse.getStatusLine().getStatusCode());
////
////        // verify user is indeed added
////        request = new HttpGet("http://localhost:8080/Kwetter/resources/user/aap");
////        httpResponse = HttpClientBuilder.create().build().execute(request);
////        assertEquals(200,httpResponse.getStatusLine().getStatusCode());
//    }
//}
