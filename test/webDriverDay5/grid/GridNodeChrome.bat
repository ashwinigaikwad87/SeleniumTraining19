c:
cd "C:\LearnJava\webdrivertraining\lib"
java ^
-Dwebdriver.chrome.driver="C:\LearnJava\webdrivertraining\test\resources\chromedriver.exe" ^
-jar selenium-server-standalone-3.141.59.jar -role node ^
-hub http://ondemand.saucelabs.com:80/grid/register ^
-browser "browserName=chrome,maxInstances=3" ^
-maxSession 3
pause