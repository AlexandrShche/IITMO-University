package command.command;

import worker.Organization;

public abstract class CommandWithOrganizationArg implements CommandWithArg{
    Organization organization;
    public void setArg(Organization organization){
        this.organization = organization;
    }
}
