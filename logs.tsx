import { IonContent, IonHeader, IonPage, IonTitle, IonToolbar, IonList, IonItem, IonText, IonButton, IonIcon, IonSearchbar, IonInput } from '@ionic/react';
import React, { useState, useEffect } from 'react';
import ExploreContainer from '../components/ExploreContainer';
import './Home.css';

const Home: React.FC = () => {

  const[input, setInput] = useState<string>('')
  useEffect(() => {
    console.log(input)
  }, [input])
  return (
    <IonPage>
      <IonHeader>
        <IonToolbar>
          <IonTitle>list des log</IonTitle>
        </IonToolbar>
      </IonHeader>
      <br />
      <IonText>Logs</IonText>
      <IonContent className="ion-padding">
        {/* <IonHeader collapse="condense">
          <IonToolbar>
            <IonTitle size="large">LogApp</IonTitle>
          </IonToolbar>
        </IonHeader> */}
        {/* <IonList>
          {Array(10)
          .fill(0)
          .map((_, i) => (
            <IonItem>
              <IonText>List Item {i}</IonText>
            </IonItem>
          ))}
        </IonList> */}
       {/*  <IonInput 
        value={input}
        onIonChange={(e: any) => setInput(e.target.value)}>username</IonInput>
        <IonInput>passwd</IonInput>
        <IonButton color="primary">Send
            <IonIcon slot="end"></IonIcon>
        </IonButton> */}
        <IonButton routerLink="/home">home</IonButton>
      </IonContent>
    </IonPage>
  );
};

export default Home;
