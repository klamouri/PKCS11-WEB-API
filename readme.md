# PKCS11-WEB-API
This application is a web application which need to be deployed on a web server. This WEB Application is based upon Jersey.

## Dependencies (not included in this project)
1. Tomcat
2. [PKCS11 Wrapper](https://jce.iaik.tugraz.at/sic/Products/Core_Crypto_Toolkits/PKCS_11_Wrapper)
3. Maven
 
## Setup the application
1. `git clone https://github.com/klamouri/PKCS11-WEB-API.git`
2. `cd PKCS11-WEB-API`
3. Put the [PKCS11 Wrapper jar](https://jce.iaik.tugraz.at/sic/Products/Core_Crypto_Toolkits/PKCS_11_Wrapper) in the folder `libs/iaik/pkcs11Wrapper/1.0/` under the name `pkcs11Wrapper-1.0.jar`
4. The application is ready to be deployed

## Test
To know if your application is correctly deployed.  
Make sure there is no tomcat already running.

    mvn tomcat7:run 
    curl http://<yourhost>:<port>/pkcs11-api/webapi/myresource

If the application is correctly setup you should see the following message

>Got it!

## Deploy the application
If you're just developping with this API, you just have to follow the instructions in the Test section.

1. `cd PKCS11-WEB-API`
2. `mvn package`
3. Find your `pkcs11-api.war` file ready to be deployed in `target/pkcs11-api.war`
4. Deploy it in tomcat



## Licence

This application is under MIT Licence. (At the exception of the wrapper)