import java.util.Scanner;

class Buku {
    String judul;
    String penulis;
    int tahunTerbit;

    public Buku(String judul, String penulis, int tahunTerbit) {
        this.judul = judul;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
    }
}

class Node {
    Buku data;
    Node next;

    public Node(Buku data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public void addNode(Buku data, boolean atFront) {
        Node newNode = new Node(data);

        if (atFront) {
            newNode.next = head;
            head = newNode;
        } else {
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }

        System.out.println("Data buku berhasil ditambahkan.\n");
    }

    public void deleteNode(boolean fromFront) {
        if (head == null) {
            System.out.println("List buku kosong.");
            return;
        }

        if (fromFront) {
            head = head.next;
        } else {
            Node current = head;
            Node prev = null;

            while (current.next != null) {
                prev = current;
                current = current.next;
            }

            if (prev != null) {
                prev.next = null;
            } else {
                head = null;
            }
        }

        System.out.println("Data buku berhasil dihapus.\n");
    }

    public void printList() {
        if (head == null) {
            System.out.println("List buku kosong.");
            return;
        }

        System.out.println("------------------------");
        Node current = head;
        while (current != null) {
            System.out.println("Judul: " + current.data.judul);
            System.out.println("Penulis: " + current.data.penulis);
            System.out.println("Tahun Terbit: " + current.data.tahunTerbit);
            System.out.println("------------------------");
            current = current.next;
        }
    }
}

public class jurnal03LinkedList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList linkedList = new LinkedList();

        int pilihan;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Cetak Daftar Buku");
            System.out.println("4. Keluar");
            System.out.print("Pilih operasi: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    scanner.nextLine(); 
                    System.out.print("Masukkan Judul Buku: ");
                    String judul = scanner.nextLine();
                    System.out.print("Masukkan Penulis: ");
                    String penulis = scanner.nextLine();
                    System.out.print("Masukkan Tahun Terbit: ");
                    int tahunTerbit = scanner.nextInt();
                    linkedList.addNode(new Buku(judul, penulis, tahunTerbit), true);
                    break;
                case 2:
                    System.out.println("Pilihan untuk menghapus buku belum diimplementasikan.");
                    break;
                case 3:
                    linkedList.printList();
                    break;
                case 4:
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        } while (pilihan != 4);
    }
}
    

