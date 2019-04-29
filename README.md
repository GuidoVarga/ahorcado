# ahorcado

Diferencia entre Thread y Runnable

Thread es una clase y Runnable una interface.

En ambos se debe sobreescribir el metodo run. Se inicializan con start, pero una clase que implementa Runnable, primero debe ser pasada a una instancia de Thread para iniciarlo desde ahi.

New: El thread está en nuevo estado si creas una instancia de la clase Thread pero antes de la invocación del método start ().

Runnable: El thread está en estado ejecutable (runnable) después de la invocación del método start (), pero el programador de threads (thread scheduler) no lo ha seleccionado como el thread en ejecución.

Running: El thread está en estado de ejecución si el programador de threads lo ha seleccionado.

Blocked: No es elegible para ejecutarse. Metodos que ponen un thread en este estado son: sleep(), suspend(), wait().

Dead: Termino de ejecutarse su metodo run.

Metodos:

Start() inicia el hilo llamando al método run();

Sleep() deja de ejecutar un hilo por un tiempo determinado

Yield(): Provoca una pausa temporal en el thread para dar la oportunidad a otros threads de que ejecuten

Join(): Se utiliza para esperar el fin de la ejecución de un thread antes de realizar acciones que dependan de ello.