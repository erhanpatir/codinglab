import DataStructures.Arrays.MajorityElement;
import DataStructures.Arrays.MoveZeroes;


void main() {
    run(283);
}

void run (int questionNumber) {
    switch(questionNumber) {
        case 283:
            MoveZeroes.moveZeroes(new int[] {0,1,0,3,12});
            break;
        case 169:
            MajorityElement.majorityElement(new int[] {2,2,1,1,1,2,2});
            break;
    }
}
