package br.com.fernando.leticia.casamento.util;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Validador {

    private Validador() {
        throw new AssertionError();
    }

    /**
     * Verifica se um objeto é nulo. Caso o objeto seja nulo é retornado TRUE
     * caso contrário é retornado FALSE
     *
     * @param obj
     * @return boolean
     */
    public static boolean isNull(Object obj) {
        return obj == null;
    }

    /**
     * Verifica se um objeto não é nulo. Caso o objeto não seja nulo é retornado TRUE
     * caso contrário é retornado FALSE
     *
     * @param obj
     * @return boolean
     */
    public static boolean isNotNull(Object obj) {
        return obj != null;
    }

    /**
     * Verifica se um número indefinido de objetos é nulo,
     * retorna falso caso algum esteja instanciado
     * @param objects
     * @return
     * @author jabezerra
     */
    public static boolean isNull(Object...objects) {
        if (objects != null) {
            for(Object objeto : objects) {
                if (objeto == null) {
                    return true;
                }
            }
            return false;
        } else {
            return true;
        }
    }

    /**
     * Verifica se um número indefinido de objetos não é nulo,
     * retorna falso caso algum esteja nulo
     * @param objects
     * @return
     * @author jabezerra
     */
    public static boolean isNotNull(Object...objects) {
        if (objects != null) {
            for(Object objeto : objects) {
                if (objeto == null) {
                    return false;
                }
            }
            return true;
        }else {
            return false;
        }
    }

    public static boolean isArrayValid(Object[] array) {
        return array != null && array.length > 0;
    }

    /**
     * Verifica se uma String é válida, caso a String seja diferente de nula,
     * não contenha SOMENTE espaços em branco E não seja vazia, ela é
     * considerada válido, caso uma dessas trÊs condições não seja atendida ela
     * é considera inválida.
     *
     * @param str
     * @return boolean
     */
    public static boolean isStringValid(String str) {
        return str != null
                && !str.equalsIgnoreCase("")
                && !str.trim().isEmpty();
    }

    /**
     * Verifica se uma determinada collection está válida
     *
     * @param collection
     * @return Boolean retorna true se a collection é nula ou está vazia, e false, em caso contrário.
     */
    public static <T> boolean isCollectionNotValid(Collection<T> collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * Valida se uma lista é vazia ou nula
     * @param list
     * @return boolean retorna true se uma lista não for vazia ou nula, e false, caso contrário.
     */
    public static boolean isListValid(List<?> list) {
        return list != null && !list.isEmpty();
    }

    public static boolean isListValid(Map<?, ?> map) {
        return map != null && !map.isEmpty();
    }

    public static boolean isListValid(Set<?> set) {
        return  set != null && !set.isEmpty();
    }

    public static <T> boolean isCollectionValid(Collection<T>  collection) {
        return collection != null && !collection.isEmpty();
    }
}


