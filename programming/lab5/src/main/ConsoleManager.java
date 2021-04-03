package main;

import exeptions.InvalidNameException;
import exeptions.InvalidPositionException;
import exeptions.InvalidStatusException;
import exeptions.InvalidWorkerFieldException;
import main.worker.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;

public class ConsoleManager implements CommandAndOutputManager {
    private final Messages messages;
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final CommandFactory commandFactory;
    CollectionOfWorkerManager collectionOfWorkerManager;

    private boolean isRunning;

    public ConsoleManager(Messages messages, CommandFactory commandFactory,
                          CollectionOfWorkerManager collectionOfWorkerManager) {
        this.messages = messages;
        this.commandFactory = commandFactory;
        this.collectionOfWorkerManager = collectionOfWorkerManager;
    }

    @Override
    public void readCommands() {
        isRunning = true;
        while(isRunning){
            try {
                String[] command = reader.readLine().trim().split("\\s+");
                if (command.length == 1)
                    commandFactory.executeCommand(command[0],
                            this, null, collectionOfWorkerManager);
                else
                    commandFactory.executeCommand(command[0],
                            this, command[1], collectionOfWorkerManager);
            } catch (Exception e){
                if (e.getMessage() != null)
                    System.err.println(e.getMessage());
                else
                    System.err.println("Error got while getting command.");
            }
        }
    }

    @Override
    public void output(String string) {
        System.out.println(string);
    }

    @Override
    public Worker readWorker(){
        Worker worker = new OrdinaryWorker();
        System.out.println(messages.getInputFieldMessage());
        curSetName(worker);
        System.out.println(messages.getInputCoordinatesMassage());
        curSetCoordinates(worker);
        curSetSalary(worker);
        curSetEndDate(worker);
        curSetPosition(worker);
        curSetStatus(worker);
        System.out.println(messages.getInputOrganizationMessage());
        curSetOrganization(worker);

        return worker;
    }

    private void curSetName(Worker worker) {
        try {
            System.out.println(messages.getInputNameMassage());
            String name = reader.readLine().trim().toLowerCase();
            worker.setName(name);
        }catch (InvalidNameException|IOException e){
            if( e.getMessage() != null){
                System.out.println(e.getMessage());
            }
            System.out.println(messages.getTryAgainMessage());
            System.out.println(messages.getInputNameMassage());
            curSetName(worker);
        }
    }

    private void curSetCoordinates(Worker worker) {
        try{
            Coordinates coordinates = new OrdinaryCoordinates();
            System.out.println(messages.getInputXCoordinatesMessage());
            Double x = new Double(reader.readLine().trim());
            coordinates.setX(x);
            System.out.println(messages.getInputYCoordinatesMessage());
            float y = new Float(reader.readLine().trim());
            coordinates.setY(y);
            worker.setCoordinates(coordinates);
        } catch (InvalidWorkerFieldException|IOException e){
            if (e.getMessage() != null){
                System.out.println(e.getMessage());
            }
            System.out.println(messages.getTryAgainMessage());
            curSetCoordinates(worker);
        }

    }

    private void curSetStatus(Worker worker) {
        try{
            System.out.println(messages.getInputStatusMessage());
            String status = reader.readLine().trim().toLowerCase();
            Status s;
            if(status.matches("recommend\\s+for\\s+promotion")){
                s = Status.RECOMMENDED_FOR_PROMOTION;
            }
            else {
                switch (status.toLowerCase()) {

                    case "fired":
                        s = Status.FIRED;
                        break;
                    case "probation":
                        s = Status.PROBATION;
                        break;
                    default:
                        throw new InvalidStatusException();
                }
            }
            worker.setStatus(s);
        } catch (InvalidWorkerFieldException | IOException e) {
            if(e.getMessage() != null)
            System.out.println(e.getMessage());
            System.out.println(messages.getTryAgainMessage());
            curSetStatus(worker);
        }
    }

    private void curSetPosition(Worker worker) {
        try {
            System.out.println(messages.getInputPositionMessage());
            Position p;
            String position = reader.readLine().toLowerCase().trim();
            position = position.toLowerCase();
            if (position.matches("lead\\s+developer")) {
                p = Position.LEAD_DEVELOPER;
            } else {
                switch (position) {
                    case "manger":
                        p = Position.MANAGER;
                        break;
                    case "engineer":
                        p = Position.ENGINEER;
                        break;
                    case "developer":
                        p = Position.DEVELOPER;
                        break;
                    case "baker":
                        p = Position.BAKER;
                        break;
                    default:
                        throw new InvalidPositionException();
                }
            }
            worker.setPosition(p);
        } catch (InvalidWorkerFieldException|IOException e){
            if(e.getMessage() != null)
                System.out.println(e.getMessage());
            System.out.println(messages.getTryAgainMessage());
            curSetPosition(worker);
        }
    }

    private void curSetEndDate(Worker worker) {
        try {
            System.out.println(messages.getInputEndDateMessage());
            java.time.ZonedDateTime endDate = ZonedDateTime.parse(reader.readLine().trim());
            worker.setEndDate(endDate);
        } catch (InvalidWorkerFieldException|IOException|DateTimeParseException e){
            if(e.getMessage() != null){
                System.out.println(e.getMessage());
            }
            System.out.println(messages.getTryAgainMessage());
            curSetEndDate(worker);
        }
    }

    private void curSetSalary(Worker worker) {
        try {
            System.out.println(messages.getInputSalaryMessage());
            Double salary = new Double(reader.readLine());
            worker.setSalary(salary);
        } catch (InvalidWorkerFieldException|IOException e){
            if(e.getMessage() != null){
                System.out.println(e.getMessage());
            }
            System.out.println(messages.getTryAgainMessage());
            curSetSalary(worker);
        }
    }

    private void curSetOrganization(Worker worker) {
        try {
            System.out.println(messages.getInputFullNameOrganizationMessage());
            Organization organization = new OrdinaryOrganization();
            organization.setFullName(reader.readLine().trim());
            System.out.println(messages.getInputAnnualTurnoverOrganizationMessage());
            Integer annualTurnover = new Integer(reader.readLine().trim());
            organization.setAnnualTurnover(annualTurnover);
            System.out.println(messages.getInputOfficialAddressMessage());
            curSetOfficialAddress(organization);
            worker.setOrganization(organization);
        } catch (InvalidWorkerFieldException|IOException e){
            if(e.getMessage() != null){
                System.out.println(e.getMessage());
            }
            System.out.println(messages.getTryAgainMessage());
            curSetOrganization(worker);
        }
    }

    private void curSetOfficialAddress(Organization organization) {
        try{
            Address address = new OrdinaryAddress();
            System.out.println(messages.getInputStreetForAddress());
            address.setStreet(reader.readLine().trim());
            address.setZipCode(reader.readLine().trim());
            curSetTown(address);
            organization.setOfficialAddress(address);
        } catch(IOException e) {
            if(e.getMessage() != null){
                System.out.println(e.getMessage());
            }
            System.out.println(messages.getTryAgainMessage());
            curSetOfficialAddress(organization);
        }
    }

    private void curSetTown(Address address) {
        try {
            System.out.println(messages.getInputTownName());
            Location town = new OrdinaryLocation();
            town.setName(reader.readLine().trim());

            System.out.println(messages.getInputTownX());
            Double x = new Double(reader.readLine().trim());
            town.setX(x);

            System.out.println(messages.getInputTownY());
            Double y = new Double(reader.readLine().trim());
            town.setY(y);

            address.setTown(town);
        } catch(InvalidWorkerFieldException|IOException|NumberFormatException e) {
            if(e.getMessage() != null){
                System.out.println(e.getMessage());
            }
            System.out.println(messages.getTryAgainMessage());
            curSetTown(address);
        }
    }

    @Override
    public void exit() {
        isRunning = false;
    }

    @Override
    public Organization readOrganization() {
        Worker worker = new OrdinaryWorker();
        curSetOrganization(worker);
        return worker.getOrganization();
    }

    @Override
    public void output(Worker w) {
        System.out.println("id:");
        System.out.println("\t" + w.getId());

        System.out.println("Имя:");
        System.out.println("\t" + w.getName());

        System.out.println("Координаты:");
        System.out.println("X:");
        System.out.println("\t" + w.getCoordinates().getX());
        System.out.println("Y:");
        System.out.println("\t" + w.getCoordinates().getY());

        System.out.println("Дата внесения:");
        System.out.println("\t" + w.getCreationDate());

        System.out.println("Зарплата:");
        System.out.println("\t" + w.getSalary());

        if(w.getEndDate() != null) {
            System.out.println("Дата увольнения:");
            System.out.println("\t" + w.getEndDate());
        }

        System.out.println("Должность:");
        System.out.println("\t" + w.getPosition());

        System.out.println("Статус:");
        System.out.println(w.getStatus());

        if(w.getOrganization() != null){
            System.out.println("Организация:");
            System.out.println("\t" + "Имя:");
            System.out.println("\t\t" + w.getOrganization().getFullName());
            if(w.getOrganization().getAnnualTurnover() != null) {
                System.out.println("\t" + "Годовой оборот:");
                System.out.println("\t\t" + w.getOrganization().getAnnualTurnover());
            }
            if(w.getOrganization().getOfficialAddress() != null){
                System.out.println("\t" + "Официальный  адрес:");
                if(w.getOrganization().getOfficialAddress().getStreet() != null){
                    System.out.println("\t\t" + "Улица:");
                    System.out.println("\t\t\t" + w.getOrganization()
                                                    .getOfficialAddress()
                                                        .getStreet());
                }
                System.out.println("\t\tПочтовый индекс:");
                System.out.println("\t\t\t" +
                        w.getOrganization().getOfficialAddress().getZipCode());

                System.out.println("\t\tГород:");
                if(w.getOrganization().getOfficialAddress().getTown().getName() != null) {
                    System.out.println("\t\t\tНазвание города:");
                    System.out.println("\t\t\t\t" +
                            w.getOrganization().getOfficialAddress().getTown().getName());
                }
                System.out.println("\t\t\tКоордината Х города:");
                System.out.println("\t\t\t\t" +
                        w.getOrganization().getOfficialAddress().getTown().getX());

                System.out.println("\t\t\tКоордината Y города:");
                System.out.println("\t\t\t\t" +
                        w.getOrganization().getOfficialAddress().getTown().getY());
            }

        }

    }
}
