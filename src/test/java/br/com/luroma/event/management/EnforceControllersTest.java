package br.com.luroma.event.management;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "br.com.luroma.event.management")
public class EnforceControllersTest {

    @ArchTest
    public static final ArchRule controllersShouldBeOnWebPackage =  classes()
            .that().haveSimpleNameEndingWith("Controller")
            .should().resideInAPackage("br.com.luroma.event.management.web");

    @ArchTest
    public static final ArchRule noPublicClassesTharAreNotInterfaces =  classes()
            .that().areNotInterfaces()
            .or().haveSimpleNameEndingWith("Repository")
            .and().resideInAPackage("..component..")
            .should().notBePublic();
}