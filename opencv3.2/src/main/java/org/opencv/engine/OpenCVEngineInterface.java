package org.opencv.engine;

/**
 * Created by ddx on 2017/8/12.
 */

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface OpenCVEngineInterface extends IInterface {
    int getEngineVersion() throws RemoteException;

    String getLibPathByVersion(String var1) throws RemoteException;

    boolean installVersion(String var1) throws RemoteException;

    String getLibraryList(String var1) throws RemoteException;

    public abstract static class Stub extends Binder implements OpenCVEngineInterface {
        private static final String DESCRIPTOR = "org.opencv.engine.OpenCVEngineInterface";
        static final int TRANSACTION_getEngineVersion = 1;
        static final int TRANSACTION_getLibPathByVersion = 2;
        static final int TRANSACTION_installVersion = 3;
        static final int TRANSACTION_getLibraryList = 4;

        public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        public static OpenCVEngineInterface asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            } else {
                IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
                return (OpenCVEngineInterface) (iin != null && iin instanceof OpenCVEngineInterface ? (OpenCVEngineInterface) iin : new OpenCVEngineInterface.Stub.Proxy(obj));
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String _arg0;
            String _result;
            switch (code) {
                case TRANSACTION_getEngineVersion:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg01 = this.getEngineVersion();
                    reply.writeNoException();
                    reply.writeInt(_arg01);
                    return true;
                case TRANSACTION_getLibPathByVersion:
                    data.enforceInterface(DESCRIPTOR);
                    _arg0 = data.readString();
                    _result = this.getLibPathByVersion(_arg0);
                    reply.writeNoException();
                    reply.writeString(_result);
                    return true;
                case TRANSACTION_installVersion:
                    data.enforceInterface(DESCRIPTOR);
                    _arg0 = data.readString();
                    boolean _result1 = this.installVersion(_arg0);
                    reply.writeNoException();
                    reply.writeInt(_result1 ? 1 : 0);
                    return true;
                case TRANSACTION_getLibraryList:
                    data.enforceInterface(DESCRIPTOR);
                    _arg0 = data.readString();
                    _result = this.getLibraryList(_arg0);
                    reply.writeNoException();
                    reply.writeString(_result);
                    return true;
                case 1598968902:
                    reply.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements OpenCVEngineInterface {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return DESCRIPTOR;
            }

            public int getEngineVersion() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    this.mRemote.transact(TRANSACTION_getEngineVersion, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public String getLibPathByVersion(String version) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                String _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(version);
                    this.mRemote.transact(TRANSACTION_getLibPathByVersion, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readString();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public boolean installVersion(String version) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(version);
                    this.mRemote.transact(TRANSACTION_installVersion, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt() != 0;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public String getLibraryList(String version) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                String _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(version);
                    this.mRemote.transact(TRANSACTION_getLibraryList, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readString();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }
        }
    }
}
