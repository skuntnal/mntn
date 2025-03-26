Assessment Guidelines


-	No postman scripts
-	No soapui
-	No record/play
-	Code must be turned in and executable (no copy/paste, no screenshots, ...)
-	You can link to github repo, if available


For the assessment, please choose a public API to automate and provide the following:

•	Executable automation you have written to verify the public API 
•	Explanation of your approach
•	Pros and cons of approach

Shiva:

I have created a sample, API Rest Assured Framework Skeleton with a Public facing application.
The solution is available on Git at the following path:
https://github.com/skuntnal/mntn

Also additionally shared the fat/uber jar through Google Drive as it wasn’t allowing me to attach in an email. 

All it does in the test is performs a post request and fetches couple of parameters from the response and asserts depending on the filter or search criteria.
1.	Navigate to a IRCTC website, launch a bus booking portal
2.	Enter the source, destination and date of journey fields and click enter
3.	User is returned with a bunch of options in terms of different travel companies,
time of departure, bus fare, number of seats available for the date chosen and several other parameters
4.	Make use of a specific filter criteria and assert/verify based on that

I have following components as part of the API automation:
1.	Test Class uses TestNG for the annotations
2.	DTO class which actuals handles the getter and setter methods for the URI
3.	Generic Helper class with utility methods like POST and other transactional operations
4.	Impl class – No methods implemented, could be utilized as the feature/scope is expanded
5.	Property file for driving the test data
6.	Pom.xml which defines the dependencies

Things that are not implemented:
1.	Error Handling
2.	Integration with a Test Management Tool

Pros:
1.	Framework/Approach is scalable
2.	It is modular
3.	Easier to debug

Cons: 
1.	Coding knowledge is necessary

