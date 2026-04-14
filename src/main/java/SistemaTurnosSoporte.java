import java.util.LinkedList;
import java.util.Queue;

public class SistemaTurnosSoporte {

    private Queue<String> cola;
    private static final int CAPACIDAD_MAXIMA = 10;

    public SistemaTurnosSoporte() {
        cola = new LinkedList<>();
    }

    public boolean registrarTurno(String codigo, String problema) {

        if (codigo == null || problema == null) return false;

        codigo = codigo.trim();
        problema = problema.trim();

        if (codigo.isEmpty() || problema.isEmpty()) return false;

        if (cola.size() >= CAPACIDAD_MAXIMA) return false;

        for (String t : cola) {
            String[] partes = t.split("\\|");
            if (partes[0].equals(codigo)) {
                return false;
            }
        }

        cola.offer(codigo + "|" + problema);
        return true;
    }

    public String verSiguienteTurno() {
        if (cola.isEmpty()) return "No hay turnos";
        return cola.peek();
    }

    public String atenderSiguienteTurno() {
        if (cola.isEmpty()) return "No hay turnos";
        return cola.poll();
    }

    public int obtenerCantidadTurnos() {
        return cola.size();
    }

    public int obtenerEspaciosDisponibles() {
        return CAPACIDAD_MAXIMA - cola.size();
    }

    public String mostrarCola() {
        if (cola.isEmpty()) return "";

        StringBuilder sb = new StringBuilder();
        for (String t : cola) {
            sb.append(t).append("\n");
        }

        return sb.toString().trim();
    }
}