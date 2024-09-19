package br.com.luroma.event.management;

import com.structurizr.Workspace;
import com.structurizr.api.WorkspaceApiClient;
import com.structurizr.model.*;
import com.structurizr.view.*;

import static com.structurizr.view.AutomaticLayout.RankDirection.LeftRight;
import static com.structurizr.view.AutomaticLayout.RankDirection.TopBottom;

public class StructurizrIntegration {
    public static void main(String[] args) throws Exception {
        Workspace workspace = new Workspace("Event Management", "Modular Monolith example application using Simon Brown's proposal of package by component.");

        Model model = workspace.getModel();
        model.setImpliedRelationshipsStrategy(new CreateImpliedRelationshipsUnlessSameRelationshipExistsStrategy());

        Person user = model.addPerson("Event Host", "The user that creates the event.");

        SoftwareSystem softwareSystem = model.addSoftwareSystem("Event Management", "System responsible for managing events.");

        Container eventManagementFrontendContainer = softwareSystem.addContainer("Web Application", "Frontend for event management", "React");
        eventManagementFrontendContainer.addTags("Web");

        Container eventManagementContainer = softwareSystem.addContainer("event-management", "Responsible for storing and managing event data", "Java & Spring Boot MVC");
        Container eventMangamentDatabaseContainer = softwareSystem.addContainer("event-mangement-db", "Stores users, events and certificates", "PostgreSQL");
        eventMangamentDatabaseContainer.addTags("Database");

        eventManagementContainer.uses(eventMangamentDatabaseContainer, "Stores event data");

        eventManagementFrontendContainer.uses(eventManagementContainer, "Gets and stores event data");
        user.uses(eventManagementFrontendContainer, "Uses");


        Component certificatesController = eventManagementContainer.addComponent("Certificates Controller");
        Component eventsController = eventManagementContainer.addComponent("Events Controller");
        Component usersController = eventManagementContainer.addComponent("Users Controller");

        Component certificateComponent = eventManagementContainer.addComponent("Certificate Component");
        Component eventComponent = eventManagementContainer.addComponent("Event Component");
        Component notificationComponent = eventManagementContainer.addComponent("Notification Component");
        Component userComponent = eventManagementContainer.addComponent("User Component");

        certificatesController.uses(certificateComponent, "Gets and creates certificates");
        eventsController.uses(eventComponent, "Gets and creates events");
        usersController.uses(userComponent, "Gets and stores users");
        certificateComponent.uses(notificationComponent, "Notifies user of new certificate");

        ViewSet views = workspace.getViews();

        SystemContextView contextView = views.createSystemContextView(softwareSystem, "SystemContext", "System Context diagram.");
        contextView.addAllElements();
        contextView.enableAutomaticLayout(LeftRight);

        ContainerView containerView = views.createContainerView(softwareSystem, "ContainerView", "Container diagram");
        containerView.addAllElements();
        containerView.enableAutomaticLayout(LeftRight);

        ComponentView componentView = views.createComponentView(eventManagementContainer, "EventManagementComponentView", "Component view for EventManagementComponent");
        componentView.addAllComponents();
        componentView.enableAutomaticLayout(TopBottom);

        Styles styles = views.getConfiguration().getStyles();
        styles.addElementStyle(Tags.SOFTWARE_SYSTEM).background("#1168bd").color("#ffffff");
        styles.addElementStyle(Tags.CONTAINER).background("#1168bd").color("#ffffff");
        styles.addElementStyle("Database").background("#1168bd").color("#ffffff").shape(Shape.Cylinder);
        styles.addElementStyle(Tags.PERSON).background("#08427b").color("#ffffff").shape(Shape.Person);
        styles.addElementStyle( "Web").background("#08427b").color("#ffffff").shape(Shape.WebBrowser);

        WorkspaceApiClient client = new WorkspaceApiClient(System.getenv("STRUCTURIZR_API_KEY"), System.getenv("STRUCTURIZR_API_SECRET"));
        client.setWorkspaceArchiveLocation(null);
            client.putWorkspace(Long.parseLong(System.getenv("STRUCTURIZR_WORKSPACE_ID")), workspace);
    }
}
