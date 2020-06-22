# CSV File Processor


### Decisions
- Observer pattern is used to make sure the csv processing is scalable and extensible to plug other sources hence
the user could subscribe to many different data sources
- Spring JPA is used for entity mapping and querying

### Assumptions

- CSV records will be in the same line and consistent
- Upon error processing has to be stopped

### Enhancements

- Currently the CSV files will be processed upon starting the app and this should be done via a batch job
- CSV parser should be used to read files with bean mapping to be able to handle exceptions better with inconsistent files
- Upon reading the file move it to a processed file folder and upon error move to an error folder
- In memory data base is used 

### Instructions to run the application

- Change database source credentials
- change csv.file.location accordingly application.yml file


https://dzone.com/articles/spring-boot-transaction-management-hello-world-exa