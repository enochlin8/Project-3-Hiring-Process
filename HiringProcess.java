import java.util.Scanner;
public class HiringProcess {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        /* My requirements are:
        1. Computer Science Experience (Internship, Schoolwork, or individual)
        2. US Citizenship
        3. Commute
        4. Criminal Record
        5. GPA
         */

        System.out.println("Applicant name: ");
        String applicantName = input.next();

        System.out.println("Do they have Computer Science Experience? (true/false)");
        boolean computerScienceExperience = input.nextBoolean();
        System.out.println("Do they have US Citizenship? (true/false)");
        boolean usCitizenship = input.nextBoolean();
        System.out.println("Can they commute to work? (true/false)");
        boolean commute = input.nextBoolean();
        System.out.println("Do they have a criminal record? (true/false)");
        boolean criminalRecord = input.nextBoolean();
        System.out.println("Is there GPA above 3.0? (true/false)");
        boolean gpa = input.nextBoolean();

        boolean[] applicantFactors = {
                computerScienceExperience, usCitizenship, commute, criminalRecord, gpa
        };

        // Point category for each factor.
        int computerScienceWeight = 5;
        int usCitizenshipWeight = 4;
        int commuteWeight = 3;
        int criminalRecordWeight = 1;
        int gpaWeight = 2;

        // Giving a true/false for whether they passed each requirement.
        boolean filter1 = computerScienceExperience(applicantFactors, computerScienceWeight);
        System.out.println("Does the applicant pass the first criteria? " + filter1);

        boolean filter2 = usCitizenship(applicantFactors, usCitizenshipWeight);
        System.out.println("Does the applicant pass the second criteria? " + filter2);

        boolean filter3 = commute(applicantFactors, commuteWeight);
        System.out.println("Does the applicant pass the third criteria? " + filter3);

        boolean filter4 = criminalRecord(applicantFactors, criminalRecordWeight);
        System.out.println("Does the applicant pass the fourth criteria? " + filter4);

        boolean filter5 = gpa(applicantFactors, gpaWeight);
        System.out.println("Does the applicant pass the fifth criteria? " + filter5);
        // Total Score and recommendation for interview based on number of points and which requirements they've passed.
        int totalScore = calculateTotalScore(applicantFactors, computerScienceWeight, usCitizenshipWeight, commuteWeight, criminalRecordWeight, gpaWeight);
        int requirements = 10;
        if (totalScore >= requirements) {
            System.out.println("Applicant: " + applicantName);
            System.out.println("Total Score: " + totalScore);
            System.out.println("I would recommend this applicant!");
        }
        else {
            System.out.println("Applicant: " + applicantName);
            System.out.println("Total Score: " + totalScore);
            System.out.println("I would not recommend this applicant!");
        }
    }

    public static boolean computerScienceExperience(boolean[] factors, int weight) {
        return factors[0] && weight > 0;
    }

    public static boolean usCitizenship(boolean[] factors, int weight) {
        return factors[1] && weight > 0;
    }

    public static boolean commute(boolean[] factors, int weight) {
        return factors[2] && weight > 0;
    }

    public static boolean criminalRecord(boolean[] factors, int weight) {
        return !factors[3] && weight > 0;
    }

    public static boolean gpa(boolean[] factors, int weight) {
        return factors[4] && weight > 0;
    }

    public static int calculateTotalScore(boolean[] factors, int computerScienceWeight, int usCitizenshipWeight, int commuteWeight, int criminalRecordWeight, int gpaWeight) {
        int totalScore = 0;
        if (factors[0]) {
            totalScore += computerScienceWeight;
        }
        if (factors[1]) {
            totalScore += usCitizenshipWeight;
        }
        if (factors[2]) {
            totalScore += commuteWeight;
        }
        if (factors[3]) {
            totalScore += criminalRecordWeight;
        }
        if (factors[4]) {
            totalScore += gpaWeight;
        }
        return totalScore;
    }

}
