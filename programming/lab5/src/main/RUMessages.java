package main;

import command.Command;

import java.util.Map;

public class RUMessages implements Messages{
    Map<String, Command> commandMap;

    public RUMessages(Map<String, Command> commands) {
        this.commandMap = commands;
    }

    @Override
    public String getCommands() {
        return "Доступные команды:\n" +
                "    help : вывести справку по доступным командам\n" +
                "    info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                "    show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                "    add  : добавить новый элемент в коллекцию\n" +
                "    update id : обновить значение элемента коллекции, id которого равен заданному\n" +
                "    remove_by_id id : удалить элемент из коллекции по его id\n" +
                "    clear : очистить коллекцию\n" +
                "    save : сохранить коллекцию в файл\n" +
                "    execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                "    exit : завершить программу (без сохранения в файл)\n" +
                "    head : вывести первый элемент коллекции\n" +
                "    remove_head : вывести первый элемент коллекции и удалить его\n" +
                "    add_if_min : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции\n" +
                "    count_less_than_organization organization : вывести количество элементов, значение поля organization которых меньше заданного\n" +
                "    print_ascending : вывести элементы коллекции в порядке возрастания\n" +
                "    print_field_descending_salary : вывести значения поля salary всех элементов в порядке убывания";
    }

    @Override
    public String getInfoAboutWorker() {
        return "id - уникальный идентификатор, генерируется программой автоматически\n" +
                "name - Имя работника\n" +
                "coordinates - координаты работника, два вещественных числа\n" +
                "creation date - дата внесения в список, генерируется автоматически\n" +
                "salary - зарплата работника\n" +
                "end date - дата окончания\n" +
                "position - должность работника\n" +
                "status - статус работника\n" +
                "organization - организация\n";

    }

    @Override
    public String getInputFieldMessage() {
        return "Введите поля работнику";
    }

    @Override
    public String getInputNameMassage() {
        return "Введите имя работника";
    }

    @Override
    public String getInputCoordinatesMassage() {
        return "Введите поля координат работника";
    }

    @Override
    public String getInputXCoordinatesMessage() {
        return "Введите поле X координат работника";
    }

    @Override
    public String getInputYCoordinatesMessage() {
        return "Введите поле Y координат работника";
    }

    @Override
    public String getInputSalaryMessage() {
        return "Введите зарплату работника";
    }

    @Override
    public String getInputEndDateMessage() {
        return "Введите дату окончания трудового договора или оставьте строку пустой, если она не оговорена";
    }

    @Override
    public String getInputPositionMessage() {
        return "Введите должность работника:\n" +
                "MANAGER - менеджер\n" +
                "ENGINEER - инженер\n" +
                "DEVELOPER - разработчик\n" +
                "LEAD_DEVELOPER - лидер команды разработки\n" +
                "BAKER - пекарь";
    }

    @Override
    public String getInputStatusMessage() {
        return "Введите статус работника одной из трех цифр:\n" +
                "FIRED - уволен\n" +
                "RECOMMENDED_FOR_PROMOTION - рекомендован к продвижению по карьерной лестнице\n" +
                "PROBATION - на испытательном сроке";
    }

    @Override
    public String getInputOrganizationMessage() {
        return "Введите поля организации-работодателя или оставьте строку пустой если информация отсутствует";
    }

    @Override
    public String getInputFullNameOrganizationMessage() {
        return "Введите полное имя организации";
    }

    @Override
    public String getInputAnnualTurnoverOrganizationMessage() {
        return "Введите годовой оборот организации";
    }

    @Override
    public String getInputOfficialAddressMessage() {
        return "Введите официальный адрес организации";
    }

    @Override
    public String getTryAgainMessage() {
        return "Давайте попробуем снова";
    }

    @Override
    public String getInputStreetForAddress() {
        return "Введите улицу адреса";
    }

    @Override
    public String getInputTownX() {
        return "Введите координату X города";
    }

    @Override
    public String getInputTownName() {
        return "Введите название города";
    }

    @Override
    public String getInputTownY() {
        return "Введите координату y города";
    }

    @Override
    public String getClearDoneMessage() {
        return "Коллекция была очищена";
    }
}
