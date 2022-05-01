package helpers;


import configuration.Urls;
import org.apache.http.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

public final class User {


    private String idGender = "1";
    private String customerFirstname = "Artem";
    private String customerLastname = "O";
    private String email = "";
    private String passwd = "qwerty";
    private String days = "4";
    private String months = "4";
    private String years = "2020";
    private String newsletter = "1";
    private String optin = "1";
    private String firstname = "Artem";
    private String lastname = "O";
    private String company = "Company";
    private String address1 = "Adress";
    private String address2 = "Address (Line 2)";
    private String city = "New York";
    private String idState = "2";
    private String postcode = "00000";
    private String idCountry = "21";
    private String other = "Additional information";
    private String phone = "3902342211";
    private String phoneMobile = "000873324";
    private String alias = "address alias";
    private String dni = "";
    private String emailCreate = "1";
    private String isNewCustomer = "1";
    private String back = "my-account";
    private String submitAccount = " ";

    public User(String email) throws Exception {
        this.email = email;
        this.registerUser();
    }

    private void registerUser() throws Exception {
       HttpPost post = new HttpPost(Urls.registerUserUrl);

        // add request parameter, form parameters
        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("id_gender", this.idGender));
        urlParameters.add(new BasicNameValuePair("customer_firstname", this.customerFirstname));
        urlParameters.add(new BasicNameValuePair("customer_lastname", this.customerLastname));
        urlParameters.add(new BasicNameValuePair("email", this.email));
        urlParameters.add(new BasicNameValuePair("passwd", this.passwd));
        urlParameters.add(new BasicNameValuePair("days", this.days));
        urlParameters.add(new BasicNameValuePair("months", this.months));
        urlParameters.add(new BasicNameValuePair("years", this.years));
        urlParameters.add(new BasicNameValuePair("newsletter", this.newsletter));
        urlParameters.add(new BasicNameValuePair("optin", this.optin));
        urlParameters.add(new BasicNameValuePair("firstname", this.firstname));
        urlParameters.add(new BasicNameValuePair("lastname", this.lastname));
        urlParameters.add(new BasicNameValuePair("company", this.company));
        urlParameters.add(new BasicNameValuePair("address1", this.address1));
        urlParameters.add(new BasicNameValuePair("address2", this.address2));
        urlParameters.add(new BasicNameValuePair("city", this.city));
        urlParameters.add(new BasicNameValuePair("id_state", this.idState));
        urlParameters.add(new BasicNameValuePair("postcode", this.postcode));
        urlParameters.add(new BasicNameValuePair("id_country", this.idCountry));
        urlParameters.add(new BasicNameValuePair("other", this.other));
        urlParameters.add(new BasicNameValuePair("phone", this.phone));
        urlParameters.add(new BasicNameValuePair("phone_mobile", this.phoneMobile));
        urlParameters.add(new BasicNameValuePair("alias", this.alias));
        urlParameters.add(new BasicNameValuePair("dni", this.dni));
        urlParameters.add(new BasicNameValuePair("email_create", this.emailCreate));
        urlParameters.add(new BasicNameValuePair("is_new_customer", this.isNewCustomer));
        urlParameters.add(new BasicNameValuePair("back", this.back));
        urlParameters.add(new BasicNameValuePair("submitAccount", this.submitAccount));


        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {

            //System.out.println(EntityUtils.toString(response.getEntity()));
        }

    }

    public String getUserLoginEmail(){
        return this.email;
    }

    public String getUserPassword(){
        return this.passwd;
    }

}
