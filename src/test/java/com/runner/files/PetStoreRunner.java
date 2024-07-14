package com.runner.files;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="./src/test/java/Feature Files/PetStore.feature", 
				glue="com.stepdefinition.files")

public class PetStoreRunner {

}
