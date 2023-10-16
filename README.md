# 99.7% Citric Liquid

## About

`99.7% Citric Liquid` is a simplified clone of the renowned game, `100% Orange Juice`. Its main
purpose is to serve as an educational tool, teaching foundational programming concepts.

📢 **Note**: This project is purely educational and will not be used for any commercial purposes.

---

## Tarea 2: Entrega Parcial 4

En esta entrega parcial, se necesitan implementar los métodos básicos para el combate además del efecto de
algunos paneles.

### Métodos básicos a implementar

A continuacion se presenta un esquema básico de la idea. (Tomado y modificado de EP4.md)

```scala
def toAttack(...): ... = {
  // Código para el ataque
}

def toDefend(...): ... = {
  // Código para defender
}

def toEvade(...): ... = {
  // Código para evadir
}
```

Además, se implementará el efecto de los paneles **Bonus** y **Drop**. Para esto, se creará
un método ``apply`` en los paneles de la siguiente forma: (Tomado y modificado de EP4.md)

```scala
trait Panel {
  def apply(...): ...
}

class BonusPanel extends Panel {
  def apply(...): ... = {
    // Código para el panel Bonus
  }
}
```

Esto se debe repetir tanto para los Paneles, como para las Norma.

Se espera avanzar lo mas posible en esta tarea, para luego ver detalles de los antes descrito.

<div style="text-align:center;">
    <img src="https://i.creativecommons.org/l/by/4.0/88x31.png" alt="Creative Commons License">
</div>

This project is licensed under the [Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/).

---
