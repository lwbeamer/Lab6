package Control;

import Exceptions.NonUniqueValueException;
import Exceptions.ValueIsEmptyException;
import Exceptions.ValueOutOfRangeException;
import WorkerData.*;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayDeque;
import java.util.Arrays;


public class Validator {

    boolean globalErrStatus = false;
    boolean[] checkCreationDate = new boolean[6];
    boolean[] checkBirthday = new boolean[5];
    boolean[] checkCoords = new boolean[5];
    boolean checkSalary = false;
    boolean checkLocationName = false;

    ArrayDeque<Worker> workers = new ArrayDeque<>();
    String idContainer = "";



    public void addElement(){

        if (workers.size()!=0){
            try {
                if (workers.getLast().getId() == 0) {
                    ServerConsole.printError("Поле ID не может быть пустым");
                    throw new ValueIsEmptyException();
                }
                if (workers.getLast().getName() == null) {
                    ServerConsole.printError("Имя не может быть пустым");
                    throw new ValueIsEmptyException();
                }
                if (!checkCoords[0]) {
                    ServerConsole.printError("Координата не может быть пустой");
                    throw new ValueIsEmptyException();
                }
                if (!checkCoords[1]) {
                    ServerConsole.printError("Координата не может быть пустой");
                    throw new ValueIsEmptyException();
                }
                if (!checkCreationDate[1]) {
                    ServerConsole.printError("Месяц не может быть пустым");
                    throw new ValueIsEmptyException();
                }
                if (!checkCreationDate[0]) {
                    ServerConsole.printError("Год не может быть пустым");
                    throw new ValueIsEmptyException();
                }
                if (!checkCreationDate[2]) {
                    ServerConsole.printError("День не может быть пустым");
                    throw new ValueIsEmptyException();
                }
                if (!checkCreationDate[3]) {
                    ServerConsole.printError("Час не может быть пустым");
                    throw new ValueIsEmptyException();
                }
                if (!checkCreationDate[4]) {
                    ServerConsole.printError("Минута не может быть пустой");
                    throw new ValueIsEmptyException();
                }
                if (!checkCreationDate[5]) {
                    ServerConsole.printError("Временная зона не может быть пустой");
                    throw new ValueIsEmptyException();
                }
                if (!checkSalary) {
                    ServerConsole.printError("Зарплата не может быть пустой");
                    throw new ValueIsEmptyException();
                }
                if (workers.getLast().getPosition() == null) {
                    ServerConsole.printError("Должность не может быть пустой");
                    throw new ValueIsEmptyException();
                }
                if (workers.getLast().getStatus() == null) {
                    ServerConsole.printError("Статус не может быть пустым");
                    throw new ValueIsEmptyException();
                }
                if (!checkBirthday[1]) {
                    ServerConsole.printError("Месяц не может быть пустым");
                    throw new ValueIsEmptyException();
                }
                if (!checkBirthday[0]) {
                    ServerConsole.printError("Год не может быть пустым");
                    throw new ValueIsEmptyException();
                }
                if (!checkBirthday[2]) {
                    ServerConsole.printError("День не может быть пустым");
                    throw new ValueIsEmptyException();
                }
                if (!checkBirthday[3]) {
                    ServerConsole.printError("Час не может быть пустым");
                    throw new ValueIsEmptyException();
                }
                if (!checkBirthday[4]) {
                    ServerConsole.printError("Минута не может быть пустой");
                    throw new ValueIsEmptyException();
                }
                if (workers.getLast().getPerson().getPassportID() == null) {
                    ServerConsole.printError("Номер паспорта не может быть пустым");
                    throw new ValueIsEmptyException();
                }
                if (checkCoords[2] || checkCoords[3] || checkCoords[4] || checkLocationName){
                    if (!checkCoords[2]) {
                        ServerConsole.printError("Координата X-location не может быть пустой");
                        throw new ValueIsEmptyException();
                    }
                    if (!checkCoords[3]) {
                        ServerConsole.printError("Координата Y-location не может быть пустой");
                        throw new ValueIsEmptyException();
                    }
                    if (!checkCoords[4]) {
                        ServerConsole.printError("Координата Z-location не может быть пустой");
                        throw new ValueIsEmptyException();
                    }
                }
            } catch (ValueIsEmptyException e){
                ServerConsole.printError("Ошибка. Некоторые поля пустые!");
                globalErrStatus = true;
            }
        }

        Arrays.fill(checkCreationDate,false);
        Arrays.fill(checkBirthday,false);
        Arrays.fill(checkCoords,false);
        checkSalary = false;
        checkLocationName = false;

        if (globalErrStatus) {
            workers.removeLast();
            globalErrStatus = false;
        }
        workers.add(new Worker(new Coordinates(),new Person(null,null)));
        workers.getLast().setCreationDate(ZonedDateTime.of(LocalDateTime.of(1,1,1,1,1),ZoneId.of("Asia/Ho_Chi_Minh")));
        workers.getLast().getPerson().setBirthday(LocalDateTime.of(1,1,1,1,1));
    }

    public void deleteIfError(){

        if (workers.size()!=0){
            try {
                if (workers.getLast().getId() == 0) {
                    ServerConsole.printError("Поле ID не может быть пустым");
                    throw new ValueIsEmptyException();
                }
                if (workers.getLast().getName() == null) {
                    ServerConsole.printError("Имя не может быть пустым");
                    throw new ValueIsEmptyException();
                }
                if (!checkCoords[0]) {
                    ServerConsole.printError("Координата не может быть пустой");
                    throw new ValueIsEmptyException();
                }
                if (!checkCoords[1]) {
                    ServerConsole.printError("Координата не может быть пустой");
                    throw new ValueIsEmptyException();
                }
                if (!checkCreationDate[1]) {
                    ServerConsole.printError("Месяц не может быть пустым");
                    throw new ValueIsEmptyException();
                }
                if (!checkCreationDate[0]) {
                    ServerConsole.printError("Год не может быть пустым");
                    throw new ValueIsEmptyException();
                }
                if (!checkCreationDate[2]) {
                    ServerConsole.printError("День не может быть пустым");
                    throw new ValueIsEmptyException();
                }
                if (!checkCreationDate[3]) {
                    ServerConsole.printError("Час не может быть пустым");
                    throw new ValueIsEmptyException();
                }
                if (!checkCreationDate[4]) {
                    ServerConsole.printError("Минута не может быть пустой");
                    throw new ValueIsEmptyException();
                }
                if (!checkCreationDate[5]) {
                    ServerConsole.printError("Временная зона не может быть пустой");
                    throw new ValueIsEmptyException();
                }
                if (!checkSalary) {
                    ServerConsole.printError("Зарплата не может быть пустой");
                    throw new ValueIsEmptyException();
                }
                if (workers.getLast().getPosition() == null) {
                    ServerConsole.printError("Должность не может быть пустой");
                    throw new ValueIsEmptyException();
                }
                if (workers.getLast().getStatus() == null) {
                    ServerConsole.printError("Статус не может быть пустым");
                    throw new ValueIsEmptyException();
                }
                if (!checkBirthday[1]) {
                    ServerConsole.printError("Месяц не может быть пустым");
                    throw new ValueIsEmptyException();
                }
                if (!checkBirthday[0]) {
                    ServerConsole.printError("Год не может быть пустым");
                    throw new ValueIsEmptyException();
                }
                if (!checkBirthday[2]) {
                    ServerConsole.printError("День не может быть пустым");
                    throw new ValueIsEmptyException();
                }
                if (!checkBirthday[3]) {
                    ServerConsole.printError("Час не может быть пустым");
                    throw new ValueIsEmptyException();
                }
                if (!checkBirthday[4]) {
                    ServerConsole.printError("Минута не может быть пустой");
                    throw new ValueIsEmptyException();
                }
                if (workers.getLast().getPerson().getPassportID() == null) {
                    ServerConsole.printError("Номер паспорта не может быть пустым");
                    throw new ValueIsEmptyException();
                }
                if (checkCoords[2] || checkCoords[3] || checkCoords[4] || checkLocationName){
                    if (!checkCoords[2]) {
                        ServerConsole.printError("Координата X-location не может быть пустой");
                        throw new ValueIsEmptyException();
                    }
                    if (!checkCoords[3]) {
                        ServerConsole.printError("Координата Y-location не может быть пустой");
                        throw new ValueIsEmptyException();
                    }
                    if (!checkCoords[4]) {
                        ServerConsole.printError("Координата Z-location не может быть пустой");
                        throw new ValueIsEmptyException();
                    }
                }
            } catch (ValueIsEmptyException e){
                ServerConsole.printError("Ошибка. Некоторые поля пустые!");
                globalErrStatus = true;
            }
        }

        if (globalErrStatus) {
            workers.removeLast();
        }
    }

    public void check(String field, String parent, String value){
        switch (field){
            case ("id"):
                checkID(value);
                break;
            case ("name"):
                checkName(value,parent);
                break;
            case ("X"):
                checkX(value,parent);
                break;
            case ("Y"):
                checkY(value, parent);
                break;
            case ("year"):
                checkYear(value, parent);
                break;
            case ("month"):
                checkMonth(value, parent);
                break;
            case ("day"):
                checkDay(value, parent);
                break;
            case ("hour"):
                checkHour(value, parent);
                break;
            case ("minute"):
                checkMinute(value, parent);
                break;
            case ("zoneID"):
                checkZoneID(value);
                break;
            case ("salary"):
                checkSalary(value);
                break;
            case ("position"):
                checkPosition(value);
                break;
            case ("status"):
                checkStatus(value);
                break;
            case ("weight"):
                checkWeight(value);
                break;
            case ("passportID"):
                checkPassportID(value);
                break;
            case ("Z"):
                checkZ(value);
                break;
            default:
                break;
        }
    }

    public void checkID(String value){
        try {
            if (idContainer.contains(value)) throw new NonUniqueValueException();
            idContainer = idContainer + value + "";
            long id = Long.parseLong(value);
            if (id > 0) {
                workers.getLast().setId(id);
            } else throw new ValueOutOfRangeException();
        } catch (NonUniqueValueException e){
            ServerConsole.printError("ID должен быть уникальным!");
            globalErrStatus = true;
        } catch (ValueOutOfRangeException e) {
            ServerConsole.printError("ID должен быть больше нуля!");
            globalErrStatus = true;
        }
    }

    public void checkName(String value, String parent){
        if (parent.equals("Worker")){
            workers.getLast().setName(value);
        } else if (parent.equals("location")) {
            checkLocationName = true;
            if (workers.getLast().getPerson().getLocation() == null) workers.getLast().getPerson().setLocation(new Location());
            if (value.isEmpty()) workers.getLast().getPerson().getLocation().setName(null);
            else workers.getLast().getPerson().getLocation().setName(value);
        }
    }

    public void checkX(String value, String parent){
        if (parent.equals("coordinates")){
            checkCoords[0] = true;
            try{
                workers.getLast().getCoordinates().setX(Long.parseLong(value));
            } catch (NumberFormatException e) {
                ServerConsole.printError("Координата должна быть представлена целым числом!");
                globalErrStatus = true;
            }
        } else if (parent.equals("location")){
            checkCoords[2] = true;
            try{
                if (workers.getLast().getPerson().getLocation() == null) workers.getLast().getPerson().setLocation(new Location());
                workers.getLast().getPerson().getLocation().setX(Double.parseDouble(value));
            } catch (NumberFormatException e) {
                ServerConsole.printError("Координата должна быть представлена числом!");
                globalErrStatus = true;
            }
        }
    }

    public void checkY(String value, String parent){
        if (parent.equals("coordinates")){
            checkCoords[1] = true;
            try{
                workers.getLast().getCoordinates().setY(Long.parseLong(value));
            } catch (NumberFormatException e) {
                ServerConsole.printError("Координата должна быть представлена целым числом!");
                globalErrStatus = true;
            }
        } else if (parent.equals("location")){
            checkCoords[3] = true;
            try{
                if (workers.getLast().getPerson().getLocation() == null) workers.getLast().getPerson().setLocation(new Location());
                workers.getLast().getPerson().getLocation().setY(Float.parseFloat(value));
            } catch (NumberFormatException e) {
                ServerConsole.printError("Координата должна быть представлена числом!");
                globalErrStatus = true;
            }
        }
    }

    public void checkYear(String value, String parent) {
        if (parent.equals("creationDate")){
            checkCreationDate[0] = true;
            try{
                workers.getLast().setCreationDate(workers.getLast().getCreationDate().withYear(Integer.parseInt(value)));
            } catch (NumberFormatException e) {
                ServerConsole.printError("Год должен быть представлен целым числом!");
                globalErrStatus = true;
            } catch (DateTimeException e){
                ServerConsole.printError("Некорректное представление даты и/или времени!");
                globalErrStatus = true;
            }
        } else if (parent.equals("birthday")){
            checkBirthday[0] = true;
            try{
                workers.getLast().getPerson().setBirthday(workers.getLast().getPerson().getBirthday().withYear(Integer.parseInt(value)));
            } catch (NumberFormatException e) {
                ServerConsole.printError("Год должен быть представлен целым числом!");
                globalErrStatus = true;
            } catch (DateTimeException e){
                ServerConsole.printError("Некорректное представление даты и/или времени!");
                globalErrStatus = true;
            }
        }
    }

    public void checkMonth(String value, String parent) {
        if (parent.equals("creationDate")){
            checkCreationDate[1] = true;
            try{
                workers.getLast().setCreationDate(workers.getLast().getCreationDate().withMonth(Integer.parseInt(value)));
            } catch (NumberFormatException e) {
                ServerConsole.printError("Месяц должен быть представлен целым числом!");
                globalErrStatus = true;
            } catch (DateTimeException e){
                ServerConsole.printError("Некорректное представление даты и/или времени!");
                globalErrStatus = true;
            }
        } else if (parent.equals("birthday")){
            checkBirthday[1] = true;
            try{
                workers.getLast().getPerson().setBirthday(workers.getLast().getPerson().getBirthday().withMonth(Integer.parseInt(value)));
            } catch (NumberFormatException e) {
                ServerConsole.printError("Месяц должен быть представлен целым числом!");
                globalErrStatus = true;
            } catch (DateTimeException e){
                ServerConsole.printError("Некорректное представление даты и/или времени!");
                globalErrStatus = true;
            }
        }
    }

    public void checkDay(String value, String parent) {
        if (parent.equals("creationDate")){
            checkCreationDate[2] = true;
            try{
                workers.getLast().setCreationDate(workers.getLast().getCreationDate().withDayOfMonth(Integer.parseInt(value)));
            } catch (NumberFormatException e) {
                ServerConsole.printError("День должен быть представлен целым числом!");
                globalErrStatus = true;
            } catch (DateTimeException e){
                ServerConsole.printError("Некорректное представление даты и/или времени!");
                globalErrStatus = true;
            }
        } else if (parent.equals("birthday")){
            checkBirthday[2] = true;
            try{
                workers.getLast().getPerson().setBirthday(workers.getLast().getPerson().getBirthday().withDayOfMonth(Integer.parseInt(value)));
            } catch (NumberFormatException e) {
                ServerConsole.printError("День должен быть представлен целым числом!");
                globalErrStatus = true;
            } catch (DateTimeException e){
                ServerConsole.printError("Некорректное представление даты и/или времени!");
                globalErrStatus = true;
            }
        }
    }

    public void checkHour(String value, String parent) {
        if (parent.equals("creationDate")){
            checkCreationDate[3] = true;
            try{
                workers.getLast().setCreationDate(workers.getLast().getCreationDate().withHour(Integer.parseInt(value)));
            } catch (NumberFormatException e) {
                ServerConsole.printError("Часы должны быть представлены целым числом!");
                globalErrStatus = true;
            } catch (DateTimeException e){
                ServerConsole.printError("Некорректное представление даты и/или времени!");
                globalErrStatus = true;
            }
        } else if (parent.equals("birthday")){
            checkBirthday[3] = true;
            try{
                workers.getLast().getPerson().setBirthday(workers.getLast().getPerson().getBirthday().withHour(Integer.parseInt(value)));
            } catch (NumberFormatException e) {
                ServerConsole.printError("Часы должны быть представлены целым числом!");
                globalErrStatus = true;
            } catch (DateTimeException e){
                ServerConsole.printError("Некорректное представление даты и/или времени!");
                globalErrStatus = true;
            }
        }
    }

    public void checkMinute(String value, String parent){
        if (parent.equals("creationDate")){
            checkCreationDate[4] = true;
            try{
                workers.getLast().setCreationDate(workers.getLast().getCreationDate().withMinute(Integer.parseInt(value)));
            } catch (NumberFormatException e) {
                ServerConsole.printError("Минуты должны быть представлены целым числом!");
                globalErrStatus = true;
            } catch (DateTimeException e){
                ServerConsole.printError("Некорректное представление даты и/или времени!");
                globalErrStatus = true;
            }
        } else if (parent.equals("birthday")){
            checkBirthday[4] = true;
            try{
                workers.getLast().getPerson().setBirthday(workers.getLast().getPerson().getBirthday().withMinute(Integer.parseInt(value)));
            } catch (NumberFormatException e) {
                ServerConsole.printError("Минуты должны быть представлены целым числом!");
                globalErrStatus = true;
            } catch (DateTimeException e){
                ServerConsole.printError("Некорректное представление даты и/или времени!");
                globalErrStatus = true;
            }
        }
    }

    public void checkZoneID(String value){
        checkCreationDate[5] = true;
        try{
            if (value.isEmpty()) throw new ValueIsEmptyException();
            workers.getLast().setCreationDate(workers.getLast().getCreationDate().withZoneSameLocal(ZoneId.of(value)));
        } catch (DateTimeException e){
            ServerConsole.printError("Некорректное представление даты и/или времени!");
            globalErrStatus = true;
        } catch (ValueIsEmptyException e){
            ServerConsole.printError("Поле не может быть пустым!");
            globalErrStatus = true;
        }
    }

    public void checkSalary(String value){
        try{
            checkSalary = true;
            if (Double.parseDouble(value) <= 0) throw new ValueOutOfRangeException();
            workers.getLast().setSalary(Double.parseDouble(value));
        } catch (NumberFormatException e){
            ServerConsole.printError("Запралата должна быть представлена числом!");
            globalErrStatus = true;
        } catch (ValueOutOfRangeException e){
            ServerConsole.printError("Зарплата должна быть больше нуля!");
            globalErrStatus = true;
        }
    }

    public void checkPosition(String value){
        if (value.equalsIgnoreCase("HUMAN_RESOURCES")) {
            workers.getLast().setPosition(Position.HUMAN_RESOURCES);
        } else if (value.equalsIgnoreCase("HEAD_OF_DIVISION")) {
            workers.getLast().setPosition(Position.HEAD_OF_DIVISION);
        } else if (value.equalsIgnoreCase("CLEANER")) {
            workers.getLast().setPosition(Position.CLEANER);
        }
    }

    public void checkStatus(String value){
        if (value.equalsIgnoreCase("HIRED")) {
            workers.getLast().setStatus(Status.HIRED);
        } else if (value.equalsIgnoreCase("RECOMMENDED_FOR_PROMOTION")) {
            workers.getLast().setStatus(Status.RECOMMENDED_FOR_PROMOTION);
        } else if (value.equalsIgnoreCase("PROBATION")) {
            workers.getLast().setStatus(Status.PROBATION);
        }

    }

    public void checkWeight(String value){
        if (value.isEmpty()) workers.getLast().getPerson().setWeight(null);
        try{
            if (Float.parseFloat(value)<=0) throw new ValueOutOfRangeException();
            workers.getLast().getPerson().setWeight(Float.parseFloat(value));
        } catch (NumberFormatException e){
            ServerConsole.printError("Вес должен быть представлен числом!");
            globalErrStatus = true;
        } catch (ValueOutOfRangeException e){
            ServerConsole.printError("Вес должен быть больше нуля!");
            globalErrStatus = true;
        }
    }

    public void checkPassportID(String value)  {
        workers.getLast().getPerson().setPassportID(value);
    }

    public void checkZ(String value) {
        checkCoords[4] = true;
        try{
            if (workers.getLast().getPerson().getLocation() == null) workers.getLast().getPerson().setLocation(new Location());
            workers.getLast().getPerson().getLocation().setZ(Double.parseDouble(value));
        } catch (NumberFormatException e) {
            ServerConsole.printError("Координата должна быть представлена числом!");
            globalErrStatus = true;
        }
    }

    public ArrayDeque<Worker> getWorkers() {
        deleteIfError();
        return workers;
    }

}
