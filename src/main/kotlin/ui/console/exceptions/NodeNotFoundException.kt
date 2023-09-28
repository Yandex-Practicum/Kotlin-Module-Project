package ui.console.exceptions

class NodeNotFoundException(nodeIdx: Int): Exception("Заметка с номером $nodeIdx не найден")