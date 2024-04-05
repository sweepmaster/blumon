
import React from 'react';
import { useAuth0 } from '@auth0/auth0-react';
import { FormularioPago } from './assets/formulario';

const Profile = () => {
    const { user } = useAuth0();

    return (
        <>
            <p> ¡Bievenido, {user.name}!</p>

            <p > Email: {user.email}</p>
            <FormularioPago userEmail={user.email}/>


        </>
    )
}

export default Profile