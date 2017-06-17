#include <QCoreApplication>
#include <iostream>

int main(int argc, char *argv[])
{
    QCoreApplication a(argc, argv);

    std::cout << "Hello Qt!" << std::endl;
    std::cout << "How do you do?" << std::endl;

    return a.exec();
}
