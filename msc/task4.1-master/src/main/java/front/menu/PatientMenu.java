package front.menu;

import front.DAO.impl.IPatientDAO;
import front.DAO.impl.IStateDAO;

import front.models.Patient;
import front.models.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import front.utils.UserHelper;

import java.time.LocalDateTime;

@Component
public class PatientMenu extends AbstractMenu implements IPatientMenu {

    @Autowired
    IMainMenu mainMenu;

    @Autowired
    IPatientDAO patientDAO;

    @Autowired
    IStateDAO stateDAO;

    private final int lowerBound = 1;
    private final int upperBound = 5;

    public PatientMenu() {
    }

    public void getMenu() {
        System.out.println(
                "Patient menu:\n" +
                        "1. Create new patient\n" +
                        "2. Show patient by ID\n" +
                        "3. Update Patient's data\n" +
                        "4. Delete Patient by ID\n" +
                        "5. Back to the Pharmacy IMenu");
    }

    public void performEnteredValue(int numberOfOperation) {
        switch (numberOfOperation) {
            case 1: {
                createNewPatient();
                break;
            }
            case 2: {
                showPatientById();
                break;
            }
            case 3: {
                updatePatientById();
            }
            break;
            case 4: {
                deletePatientById();
            }

            break;
            case 5: {
                mainMenu.performMenu();  //return to the Main menu
            }
            break;
            default:
                System.out.printf("You entered %d\n", numberOfOperation);
                getOutOfBoundsNotification(lowerBound, upperBound);

        }
    }

    private void createNewPatient() {
        System.out.println("Type in patient Phone Number without gaps");
        Integer phoneNumber = readMenuClauseConsole();

        System.out.println("Type in State code (NY, AL, etc)");
        String stateName = readStringClauseConsole();
        State state = stateDAO.findStateByName(stateName);

        Patient patient =  new Patient(phoneNumber, state, UserHelper.getCurrentUser(), LocalDateTime.now(),UserHelper.getCurrentUser(),LocalDateTime.now());

        patientDAO.create(patient);

      //  System.out.println("The following Patient has just been created: " + patient);
        performMenu();
    }

    private void updatePatientById() {
        System.out.println("Enter patient ID");
        Integer patientId = readMenuClauseConsole();
        Patient patient = patientDAO.find(patientId);

        System.out.println("Type in patient Phone Number without gaps");
        Integer phoneNumber = readMenuClauseConsole();

        System.out.println("Type in State code (NY, AL, etc)");
        String stateName = readStringClauseConsole();
        State state = stateDAO.findStateByName(stateName);

        patient.setPhone(phoneNumber);
        patient.setState(state);
        patient.setModifiedByUser(UserHelper.getCurrentUser());
        patient.setUpdatedDate(LocalDateTime.now());

        patientDAO.update(patient);

        System.out.println("The following Patient has just been updated: " + patient);
        performMenu();
    }

    private void showPatientById() {
        System.out.println("Enter patient ID");
        Integer patientId = readMenuClauseConsole();
        Patient patient = patientDAO.find(patientId);
        if (patient == null) {
            System.out.println("There is no such a Patient. Please try to use another ID");
        } else {
            System.out.println(patient);
        }
        performMenu();
    }

    private void deletePatientById() {
        System.out.println("Enter patient ID");
        Integer patientId = readMenuClauseConsole();
        patientDAO.remove(patientId);
        performMenu();
    }
}
