import { IonContent, IonHeader, IonPage, IonTitle, IonToolbar, IonList, IonItem, IonText, IonButton, IonIcon, IonSearchbar, IonInput } from '@ionic/react';
import React, { useState, useEffect } from 'react';
import ExploreContainer from '../components/ExploreContainer';
import './Home.css';

const Home: React.FC = () => {

  const[username, setUsername] = useState('')
  const[password, setPassword] = useState('')
  function LoginUser(){
    console.log(username, password)
  }
  return (
    <IonPage>
      <IonHeader>
        <IonToolbar>
          <IonTitle>LogApp</IonTitle>
        </IonToolbar>
      </IonHeader>
      <br />
      <IonText>Login</IonText>
      <IonContent className="ion-padding">
        <IonInput 
          placeholder="username"
        onIonChange={(e: any) => setUsername(e.target.value)}>username</IonInput>
        <IonInput 
          placeholder="password"
        onIonChange={(e: any) => setUsername(e.target.value)}>password</IonInput>
        <IonButton color="primary" onClick={LoginUser}>Enter
        </IonButton>
      </IonContent>
    </IonPage>
  );
};

export default Home;
