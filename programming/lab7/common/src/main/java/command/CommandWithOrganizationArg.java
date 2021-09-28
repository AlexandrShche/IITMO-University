package command;

import worker.Organization;

import java.io.Serializable;

public abstract class CommandWithOrganizationArg implements CommandWithArg, Serializable {
    protected Organization organization;
    protected boolean success;
    public void setArg(Organization organization){
        this.organization = organization;
    }
    public Organization getOrganization(){
        return organization;
    }
    @Override
    public void execute() {

    }
}
