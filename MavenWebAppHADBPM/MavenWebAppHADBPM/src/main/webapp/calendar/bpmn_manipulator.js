
var BpmnModdle = require('bpmn-moddle');

// import BpmnModdle from 'bpmn-moddle';
var xmlStrUpdated;


var result;



var moddle = new BpmnModdle();

var xmlStr =
'<?xml version="1.0" encoding="UTF-8"?>' +
'<bpmn:definitions xmlns:bpmn="http://www.omg.org/spec/BPMN/20100524/MODEL" xmlns:bpmndi="http://www.omg.org/spec/BPMN/20100524/DI" xmlns:di="http://www.omg.org/spec/DD/20100524/DI" xmlns:dc="http://www.omg.org/spec/DD/20100524/DC" id="Definitions_1" targetNamespace="http://bpmn.io/schema/bpmn">' +
  '<bpmn:process id="Process_1" isExecutable="false">' +
    '<bpmn:startEvent id="StartEvent_1" />' +
  '</bpmn:process>' +
  '<bpmndi:BPMNDiagram id="BPMNDiagram_1">' +
    '<bpmndi:BPMNPlane id="BPMNPlane_1" bpmnElement="Process_1">' +
      '<bpmndi:BPMNShape id="_BPMNShape_StartEvent_2" bpmnElement="StartEvent_1">' +
        '<dc:Bounds x="173" y="102" width="36" height="36" />' +
      '</bpmndi:BPMNShape>' +
    '</bpmndi:BPMNPlane>' +
  '</bpmndi:BPMNDiagram>' +
'</bpmn:definitions>';

var xmlStr2 =
  '<?xml version="1.0" encoding="UTF-8"?>' +
  '<bpmn2:definitions xmlns:bpmn2="http://www.omg.org/spec/BPMN/20100524/MODEL" ' +
                     'id="empty-definitions" ' +
                     'targetNamespace="http://bpmn.io/schema/bpmn">' +
  '</bpmn2:definitions>';


addEvent ();
//saveToBPMN();

function addEvent(){

  moddle.fromXML(xmlStr, function(err, definitions) {

      //var t = 'task_'+title;
      // add a root element
      var bpmnTask = moddle.create('bpmn:Task', { id: "tache" });
      definitions.get('rootElements').push(bpmnTask);

      //t2='shape'+t;
      var bpmnShape = moddle.create('bpmndi:BPMNShape', { id: "shape_tache" , bpmnElement: "tache" });
      definitions.get('rootElements').push(bpmnShape);


      moddle.toXML(definitions, function(err, xmlStrUpdated) {

        result = xmlStrUpdated;
      });
  });
}

function saveToBPMN(){



var blob2 = new Blob([result], {
 type: "text/plain;charset=utf-8"
});

var filename2 = "exemple.bpmn";

saveAs(blob2, filename2);
}
