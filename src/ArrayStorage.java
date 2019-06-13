/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    int index = 0;

    void clear() {
        for (int i = 0; i <= index - 1; i++) {
            storage[i] = null;
        }
        index = 0;
    }

    void save(Resume r) {
        if (r != null) {

            for (int i = 0; i < index; i++) {
                if (r.uuid.equals(storage[i].uuid)) {
                    System.out.println("uuid must be unique.");
                    break;
                }
            }
            storage[index] = r;
            index++;
        } else {
            System.out.println("uuid can`t be null.");
        }

    }

    Resume get(String uuid) {
        for (int i = 0; i <= index - 1; i++) {
            if (uuid.equals(storage[i].uuid)) {
                return storage[i];
            }
        }
        System.out.println("Storage don`t have this Resume");
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i <= index - 1; i++) {
            if (uuid.equals(storage[i].uuid)) {
                storage[i] = null;
                for (int j = i; j <= index - 1; j++) {
                    storage[j] = storage[j + 1];
                }
                storage[index - 1] = null;
                index--;
                break;
            }
            else{
                System.out.println("Storage don`t have this Resume");
            }
        }

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] storage1 = new Resume[index];
        for (int i = 0; i <= index - 1; i++) {
            storage1[i] = storage[i];
        }
        return storage1;
    }

    int size() {
        return index;
    }
}