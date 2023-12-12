public class Notebook {
    private int ram;
    private int memory;
    private String os;
    private String color;

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Оперативная память:" + ram + " Память:" + memory + " OS:" + os + " Цвет:" + color;
    }

    @Override
    public int hashCode() {
        return os.hashCode() + color.hashCode() + 7 * ram + 17 * memory;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Notebook) {
            Notebook notebook = (Notebook) obj;
            return os.equals(notebook.os) && color.equals(notebook.color) && memory == notebook.memory
                    && ram == notebook.ram;
        }
        return false;
    }
}
